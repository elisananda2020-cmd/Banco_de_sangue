package model;

import exception.EstoqueInsuficienteException;
import interfaces.Notificavel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Estoque implements Notificavel {

    private List<BolsaDeSangue> bolsas;
    private static final int ESTOQUE_MINIMO = 5;
    private static final String[] TIPOS_SANGUINEOS =
            {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

    public Estoque() {
        this.bolsas = new ArrayList<>();
    }


    public void adicionarBolsa(BolsaDeSangue bolsa) {
        bolsa.alterarStatus(StatusBolsa.DISPONIVEL);
        bolsas.add(bolsa);
    }

    public void retirarBolsa(String tipoSanguineo, int quantidade) throws EstoqueInsuficienteException {
        List<BolsaDeSangue> disponiveis = bolsas.stream()
                .filter(b -> b.getTipoSanguineo().equalsIgnoreCase(tipoSanguineo))
                .filter(b -> b.getStatus() == StatusBolsa.DISPONIVEL)
                .collect(Collectors.toList());

        if (disponiveis.size() < quantidade) {
            throw new EstoqueInsuficienteException(
                    "Estoque insuficiente para o tipo " + tipoSanguineo +
                    ". Disponível: " + disponiveis.size() + " bolsa(s), Solicitado: " + quantidade + " bolsa(s).");
        }

        for (int i = 0; i < quantidade; i++) {
            disponiveis.get(i).alterarStatus(StatusBolsa.UTILIZADA);
        }

        verificarEstoqueBaixo(tipoSanguineo);
    }

    public Map<String, Integer> consultar() {
        Map<String, Integer> resumo = new LinkedHashMap<>();
        for (String tipo : TIPOS_SANGUINEOS) {
            resumo.put(tipo, 0);
        }
        for (BolsaDeSangue b : bolsas) {
            if (b.getStatus() == StatusBolsa.DISPONIVEL) {
                resumo.merge(b.getTipoSanguineo(), 1, Integer::sum);
            }
        }
        return resumo;
    }

    public List<BolsaDeSangue> listarBolsas() {
        return bolsas;
    }

    private List<String> tiposAlertados = new ArrayList<>();

   private void verificarEstoqueBaixo(String tipoSanguineo) {

    long qtd = bolsas.stream()
            .filter(b -> b.getTipoSanguineo().equalsIgnoreCase(tipoSanguineo))
            .filter(b -> b.getStatus() == StatusBolsa.DISPONIVEL)
            .count();

    if (qtd < ESTOQUE_MINIMO) {

        if (!tiposAlertados.contains(tipoSanguineo)) {

            notificar("Estoque crítico para o tipo sanguíneo "
                    + tipoSanguineo +
                    "! Restam apenas " + qtd + " bolsa(s).");

            tiposAlertados.add(tipoSanguineo);
        }

    } else {

        tiposAlertados.remove(tipoSanguineo);

    }
}

    @Override
    public void notificar(String mensagem) {
        System.out.println("[ALERTA] " + mensagem);
    }
}
