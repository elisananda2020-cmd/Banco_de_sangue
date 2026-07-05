package view;

import control.DoacaoController;
import control.DoadorController;
import control.EstoqueController;
import exception.DoadorNaoEncontradoException;
import exception.EstoqueInsuficienteException;
import exception.TipoSanguineoInvalidoException;
import model.BolsaDeSangue;
import model.Doacao;
import model.Doador;
import model.Funcionario;
import persistencia.BancoDeSangueRepositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private DoadorController doadorController;
    private DoacaoController doacaoController;
    private EstoqueController estoqueController;
    private Funcionario funcionarioLogado;

   public Menu() {

    this.scanner = new Scanner(System.in);

    BancoDeSangueRepositorio repositorio = new BancoDeSangueRepositorio();

    this.estoqueController = new EstoqueController(repositorio);
    this.doadorController = new DoadorController(repositorio);
    this.doacaoController = new DoacaoController(repositorio, this.estoqueController);

    this.funcionarioLogado = new Funcionario(
            "Administrador",
            "000.000.000-00",
            "68999999999",
            LocalDate.of(1990, 1, 1),
            1001);
}

    public void iniciar() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Banco de Sangue!");
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt();
            switch (opcao) {
                case 1:
                    cadastrarDoador();
                    break;
                case 2:
                    registrarDoacao();
                    break;
                case 3:
                    consultarEstoque();
                    break;
                case 4:
                    registrarSaidaBolsa();
                    break;
                case 5:
                    consultarHistoricoDoacoes();
                    break;
                case 6:
                    buscarDoadorPorCpf();
                    break;
                case 7:
                    emitirRelatorio();
                    break;
                case 8:
                    listarBolsas();
                    break;
                case 9:
                     listarDoadores();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n===== SISTEMA DE GERENCIAMENTO DE BANCO DE SANGUE =====");
        System.out.println("1 - Cadastrar doador");
        System.out.println("2 - Registrar doação");
        System.out.println("3 - Consultar estoque geral");
        System.out.println("4 - Registrar saída de bolsa (uso)");
        System.out.println("5 - Consultar histórico de doações");
        System.out.println("6 - Buscar doador por CPF");
        System.out.println("7 - Emitir relatório (funcionário)");
        System.out.println("8 - Listar Doadores");

        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarDoador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Tipo sanguíneo (ex: O+, A-, AB+): ");
        String tipoSanguineo = scanner.nextLine().trim().toUpperCase();
        System.out.print("Peso (kg): ");
        double peso = lerDouble();

        Doador doador = new Doador(nome, cpf, telefone, LocalDate.now(), tipoSanguineo, peso);
        try {
            doadorController.cadastrarDoador(doador);
            System.out.println("Doador cadastrado com sucesso!");

        } catch (TipoSanguineoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
        }
    }

    private void registrarDoacao() {

    System.out.print("CPF do doador: ");
    String cpf = scanner.nextLine();

    try {

        Doador doador = doadorController.buscarDoador(cpf);

        doacaoController.registrarDoacao(
                doador,
                LocalDate.now());

        System.out.println("Doação registrada com sucesso!");

    } catch (DoadorNaoEncontradoException | IllegalArgumentException e) {

        System.out.println("Erro: " + e.getMessage());

    }
}

private void listarDoadores() {

    List<Doador> doadores = doadorController.listarDoadores();

    if (doadores.isEmpty()) {
        System.out.println("Nenhum doador cadastrado.");
        return;
    }

    System.out.println("\n===== DOADORES CADASTRADOS =====");

    for (Doador d : doadores) {
        System.out.println(d);
        System.out.println("--------------------------------");
    }
}

    private void consultarEstoque() {
        Map<String, Integer> estoque = estoqueController.consultarEstoque();
        System.out.println("--- Estoque atual do banco de sangue ---");
        for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " bolsa(s)");
        }
    }

    private void registrarSaidaBolsa() {
        System.out.print("Tipo sanguíneo (ex: O, A, AB): ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        System.out.print("Quantidade de bolsas a retirar: ");
        int quantidade = lerInt();
        try {
            estoqueController.retirarBolsa(tipo, quantidade);
            System.out.println("Saída registrada com sucesso!");
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void consultarHistoricoDoacoes() {
        List<Doacao> historico = doacaoController.listarHistorico();
        System.out.println("--- Histórico de doações ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma doação registrada até o momento.");
        } else {
            for (Doacao d : historico) {
                System.out.println(d);
            }
        }
    }

    private void buscarDoadorPorCpf() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        try {
            Doador doador = doadorController.buscarDoador(cpf);
            System.out.println(doador.exibirInfo());
        } catch (DoadorNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void emitirRelatorio() {
        funcionarioLogado.emitirRelatorio();
    }

    private void listarBolsas() {
        List<BolsaDeSangue> bolsas = estoqueController.listarBolsas();
        System.out.println("--- Lista de bolsas de sangue cadastradas no estoque ---");
        if (bolsas.isEmpty()) {
            System.out.println("Nenhuma bolsa cadastrada até o momento.");
        } else {
            for (BolsaDeSangue b : bolsas) {
                System.out.println(b);
            }
        }
    }

    private double lerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Considerando 0.");
            return 0;
        }
    }

    private int lerInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
