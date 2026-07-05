package persistencia;

import model.Estoque;

public class EstoqueRepositorio {

    private Estoque estoque;

    public EstoqueRepositorio(Estoque estoque) {
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
