package model;

import interfaces.Relatorio;

import java.time.LocalDate;

public class Funcionario extends Pessoa implements Relatorio {

    private int matricula;

    public Funcionario(String nome, String cpf, String telefone, LocalDate dataNascimento, int matricula) {
        super(nome, cpf, telefone, dataNascimento);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void emitirRelatorio() {
        System.out.println(gerarRelatorio());
    }

    @Override
    public String gerarRelatorio() {
        return "===== Relatório emitido por " + getNome() + " (matrícula " + matricula + ") em "
                + LocalDate.now() + " =====";
    }

    @Override
    public String exibirInfo() {
        return String.format("Funcionário: %s | Matrícula: %d | Telefone: %s",
                getNome(), matricula, getTelefone());
    }
}
