package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Doador extends Pessoa {

    private String tipoSanguineo;
    private double peso;
    private boolean apto;
    private List<Doacao> doacoes;

    public Doador(String nome, String cpf, String telefone, LocalDate dataNascimento,
                  String tipoSanguineo, double peso) {
        super(nome, cpf, telefone, dataNascimento);
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.doacoes = new ArrayList<>();
        this.apto = verificarAptidao();
    }

    private boolean verificarAptidao() {
        return this.peso >= 50.0;
    }

    public void cadastrar() {
        System.out.println("Doador \"" + getNome() + "\" cadastrado com sucesso!");
    }

    public void adicionarDoacao(Doacao doacao) {
        this.doacoes.add(doacao);
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        this.apto = verificarAptidao();
    }

    public boolean isApto() {
        return apto;
    }

    private static final Set<String> TIPOS_VALIDOS = Set.of(
        "A+", "A-",
        "B+", "B-",
        "AB+", "AB-",
        "O+", "O-"
);

public static boolean tipoValido(String tipo) {
    return TIPOS_VALIDOS.contains(tipo.toUpperCase());
}

    @Override
    public String exibirInfo() {
        return String.format("Doador: %s | CPF: %s | Tipo Sanguíneo: %s | Peso: %.1fkg | Apto para doar: %s | Total de doações: %d",
                getNome(), getCpf(), tipoSanguineo, peso, apto ? "Sim" : "Não", doacoes.size());
    }


    @Override
    public String toString() {
        return "Nome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nTipo Sanguíneo: " + getTipoSanguineo() +
                "\nPeso: " + getPeso() + " kg" +
                "\nTelefone: " + getTelefone();
    }
    }