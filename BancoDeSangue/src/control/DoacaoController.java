package control;

import model.BolsaDeSangue;
import model.Doacao;
import model.Doador;
import model.StatusBolsa;
import persistencia.DoacaoRepositorio;

import java.time.LocalDate;
import java.util.List;

public class DoacaoController {

    private DoacaoRepositorio repositorio;
    private EstoqueController estoqueController;
    private int proximoId;

    public DoacaoController(DoacaoRepositorio repositorio, EstoqueController estoqueController) {
        this.repositorio = repositorio;
        this.estoqueController = estoqueController;
        this.proximoId = 1;
    }

    public Doacao registrarDoacao(Doador doador, double quantidade, LocalDate data) {

        if (!doador.isApto()) {
            throw new IllegalArgumentException(
                    "O doador não está apto para doar (peso inferior a 50 kg).");
        }

        if (quantidade < 420 || quantidade > 470) {
            throw new IllegalArgumentException(
                    "A quantidade de sangue deve estar entre 420 mL e 470 mL.");
        }
        

        Doacao doacao = new Doacao(proximoId++, data, quantidade, doador);
        doacao.registrar();

        BolsaDeSangue bolsa = doacao.getBolsaDeSangue();

        bolsa.alterarStatus(StatusBolsa.EM_ANALISE);
        bolsa.alterarStatus(StatusBolsa.APROVADA);

        estoqueController.adicionarBolsa(bolsa);

        repositorio.salvar(doacao);

        return doacao;
    }

    public List<Doacao> listarHistorico() {
        return repositorio.listarTodas();
    }
}