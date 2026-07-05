package model;

import java.util.ArrayList;
import java.util.List;


public class BancoDeSangue {

    private List<Doador> doadores;
    private List<Doacao> doacoes;
    private Estoque estoque;

    public BancoDeSangue() {
        this.doadores = new ArrayList<>();
        this.doacoes = new ArrayList<>();
        this.estoque = new Estoque();
    }

    public List<Doador> getDoadores() {
        return doadores;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
