package control;

import model.BolsaDeSangue;
import model.Doacao;
import model.Doador;
import model.StatusBolsa;
import persistencia.BancoDeSangueRepositorio;

import java.time.LocalDate;
import java.util.List;

public class DoacaoController {

    private BancoDeSangueRepositorio repositorio;
    private EstoqueController estoqueController;
    private int proximoId;

    public DoacaoController(BancoDeSangueRepositorio repositorio, EstoqueController estoqueController) {
        this.repositorio = repositorio;
        this.estoqueController = estoqueController;
        this.proximoId = 1;
    }

    public Doacao registrarDoacao(Doador doador, LocalDate data) {

        if (!doador.isApto()) {
            throw new IllegalArgumentException(
                    "O doador não está apto para doar (peso inferior a 50 kg).");
        }
        

        Doacao doacao = new Doacao(proximoId++, data,  doador);
        doacao.registrar();

        BolsaDeSangue bolsa = doacao.getBolsaDeSangue();

        bolsa.alterarStatus(StatusBolsa.EM_ANALISE);
        bolsa.alterarStatus(StatusBolsa.APROVADA);

        estoqueController.adicionarBolsa(bolsa);

        repositorio.salvarDoacao(doacao);

        return doacao;
    }

    public List<Doacao> listarHistorico() {
        return repositorio.listarDoacoes();
    }
}