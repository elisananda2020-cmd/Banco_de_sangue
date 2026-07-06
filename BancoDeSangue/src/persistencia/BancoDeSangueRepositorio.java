package persistencia;

import exception.DoadorNaoEncontradoException;
import model.Doacao;
import model.Doador;
import model.Estoque;

import java.util.ArrayList;
import java.util.List;

public class BancoDeSangueRepositorio {

    private List<Doador> doadores;
    private List<Doacao> doacoes;
    private Estoque estoque;

    public BancoDeSangueRepositorio() {
        this.doadores = new ArrayList<>();
        this.doacoes = new ArrayList<>();
        this.estoque = new Estoque();
    }

    public void salvarDoador(Doador doador) {
        doadores.add(doador);
    }

    public Doador buscarDoadorPorCpf(String cpf)
            throws DoadorNaoEncontradoException {

        for (Doador d : doadores) {
            if (d.getCpf().equalsIgnoreCase(cpf)) {
                return d;
            }
        }

        throw new DoadorNaoEncontradoException(
                "Doador com CPF \"" + cpf + "\" não foi encontrado.");
    }

    public List<Doador> listarDoadores() {
        return doadores;
    }

   

    public void salvarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }

    public List<Doacao> listarDoacoes() {
        return doacoes;
    }



    public Estoque getEstoque() {
        return estoque;
    }
}