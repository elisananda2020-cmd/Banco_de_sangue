package exception;

public class TipoSanguineoInvalidoException extends Exception {

    public TipoSanguineoInvalidoException(String tipo) {
        super("Tipo sanguíneo inválido: " + tipo +
                ". Tipos permitidos: A+, A-, B+, B-, AB+, AB-, O+, O-.");
    }
}