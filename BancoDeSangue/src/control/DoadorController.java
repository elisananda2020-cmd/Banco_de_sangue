package control;

import exception.DoadorNaoEncontradoException;
import exception.TipoSanguineoInvalidoException;
import model.Doador;
import persistencia.BancoDeSangueRepositorio;

import java.util.List;

public class DoadorController {

    private BancoDeSangueRepositorio repositorio;

    public DoadorController(BancoDeSangueRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrarDoador(Doador doador)
        throws TipoSanguineoInvalidoException {

        if (!Doador.tipoValido(doador.getTipoSanguineo())) {
        throw new TipoSanguineoInvalidoException(
                doador.getTipoSanguineo());
    }

    try {
        repositorio.buscarDoadorPorCpf(doador.getCpf());
        throw new IllegalArgumentException(
                "Já existe um doador cadastrado com este CPF.");

    } catch (DoadorNaoEncontradoException e) {

        doador.cadastrar();
        repositorio.salvarDoador(doador);
    }
}

    public Doador buscarDoador(String cpf) throws DoadorNaoEncontradoException {
        return repositorio.buscarDoadorPorCpf(cpf);
    }

    public List<Doador> listarDoadores() {
        return repositorio.listarDoadores();
    }
}