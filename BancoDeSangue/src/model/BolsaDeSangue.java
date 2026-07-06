package model;

public class BolsaDeSangue {

    private int codigo;
    private String tipoSanguineo;
    private double volume;
    private StatusBolsa status;

    public BolsaDeSangue(int codigo, String tipoSanguineo) {
        this.codigo = codigo;
        this.tipoSanguineo = tipoSanguineo;
        this.status = StatusBolsa.COLETADA;
    }

    public void alterarStatus(StatusBolsa novoStatus) {
        this.status = novoStatus;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public double getVolume() {
        return volume;
    }

    public StatusBolsa getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Bolsa #%d | Tipo: %s | Status: %s",
                codigo, tipoSanguineo, status);
    }
}
