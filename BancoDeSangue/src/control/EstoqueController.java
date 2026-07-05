package control;

import exception.EstoqueInsuficienteException;
import model.BolsaDeSangue;
import persistencia.EstoqueRepositorio;

import java.util.List;
import java.util.Map;

public class EstoqueController {

    private EstoqueRepositorio repositorio;

    public EstoqueController(EstoqueRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarBolsa(BolsaDeSangue bolsa) {
        repositorio.getEstoque().adicionarBolsa(bolsa);
    }

    public void retirarBolsa(String tipoSanguineo, int quantidade) throws EstoqueInsuficienteException {
        repositorio.getEstoque().retirarBolsa(tipoSanguineo, quantidade);
    }

    public Map<String, Integer> consultarEstoque() {
        return repositorio.getEstoque().consultar();
    }

    public List<BolsaDeSangue> listarBolsas() {
        return repositorio.getEstoque().listarBolsas();
    }
}
