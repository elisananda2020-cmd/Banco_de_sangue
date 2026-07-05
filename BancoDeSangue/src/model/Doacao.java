package model;

import java.time.LocalDate;

public class Doacao {

    private int id;
    private LocalDate data;
    private double quantidade;
    private Doador doador;
    private BolsaDeSangue bolsaDeSangue;

    public Doacao(int id, LocalDate data, Doador doador) {
        this.id = id;
        this.data = data;
        this.doador = doador;
        this.bolsaDeSangue = new BolsaDeSangue(id, doador.getTipoSanguineo());
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
        return "Doação #" + id +
            "\nData: " + data +
            "\nDoador: " + doador.getNome() +
            "\nTipo sanguíneo: " + doador.getTipoSanguineo() +
            "\nVolume: 450 mL" +
            "\n--------------";
    }
}
