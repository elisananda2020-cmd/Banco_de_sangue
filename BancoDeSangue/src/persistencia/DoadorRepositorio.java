package persistencia;

import exception.DoadorNaoEncontradoException;
import model.Doador;

import java.util.ArrayList;
import java.util.List;

public class DoadorRepositorio {

    private List<Doador> doadores;

    public DoadorRepositorio() {
        this.doadores = new ArrayList<>();
    }

    public void salvar(Doador doador) {
        doadores.add(doador);
    }

    public Doador buscarPorCpf(String cpf) throws DoadorNaoEncontradoException {
        for (Doador d : doadores) {
            if (d.getCpf().equalsIgnoreCase(cpf)) {
                return d;
            }
        }
        throw new DoadorNaoEncontradoException("Doador com CPF \"" + cpf + "\" não foi encontrado.");
    }

    public List<Doador> listarTodos() {
        return doadores;
    }
}
