package persistencia;

import model.Doacao;

import java.util.ArrayList;
import java.util.List;

public class DoacaoRepositorio {

    private List<Doacao> doacoes;

    public DoacaoRepositorio() {
        this.doacoes = new ArrayList<>();
    }

    public void salvar(Doacao doacao) {
        doacoes.add(doacao);
    }

    public List<Doacao> listarTodas() {
        return doacoes;
    }
}
