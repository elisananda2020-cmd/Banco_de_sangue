package model;

import java.time.LocalDate;

public class Doacao {

    private int id;
    private LocalDate data;
    private double quantidade;
    private Doador doador;
    private BolsaDeSangue bolsaDeSangue;

    public Doacao(int id, LocalDate data, double quantidade, Doador doador) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.doador = doador;
        this.bolsaDeSangue = new BolsaDeSangue(id, doador.getTipoSanguineo(), quantidade);
    }

    public void registrar() {
        doador.adicionarDoacao(this);
        System.out.println("Doação registrada com sucesso: " + this);
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public Doador getDoador() {
        return doador;
    }

    public BolsaDeSangue getBolsaDeSangue() {
        return bolsaDeSangue;
    }

    @Override
    public String toString() {
        return String.format("Doação #%d | Doador: %s | Data: %s | Quantidade: %.1fml | %s",
                id, doador.getNome(), data, quantidade, bolsaDeSangue);
    }
}
