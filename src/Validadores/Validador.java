package Validadores;

import java.util.ArrayList;
import java.util.List;

public abstract class Validador {
    private final List<String> erros = new ArrayList<>();

    public abstract boolean ehValido ();
    public void adicionarErros (String erro){
        this.erros.add(erro);
    }

    public List<String> getErros() {
        return erros;
    }

    @Override
    public String toString() {
        return "Validador{" +
                "erros=" + erros +
                '}';
    }
}
