package control;

import exception.DoadorNaoEncontradoException;
import exception.TipoSanguineoInvalidoException;
import model.Doador;
import persistencia.DoadorRepositorio;

import java.util.List;

public class DoadorController {

    private DoadorRepositorio repositorio;

    public DoadorController(DoadorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrarDoador(Doador doador)
        throws TipoSanguineoInvalidoException {

        if (!Doador.tipoValido(doador.getTipoSanguineo())) {
        throw new TipoSanguineoInvalidoException(
                doador.getTipoSanguineo());
    }

    try {
        repositorio.buscarPorCpf(doador.getCpf());
        throw new IllegalArgumentException(
                "Já existe um doador cadastrado com este CPF.");

    } catch (DoadorNaoEncontradoException e) {

        doador.cadastrar();
        repositorio.salvar(doador);
    }
}

    public Doador buscarDoador(String cpf) throws DoadorNaoEncontradoException {
        return repositorio.buscarPorCpf(cpf);
    }

    public List<Doador> listarDoadores() {
        return repositorio.listarTodos();
    }
}