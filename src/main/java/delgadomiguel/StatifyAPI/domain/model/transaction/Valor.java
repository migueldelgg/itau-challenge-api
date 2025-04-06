package delgadomiguel.StatifyAPI.domain.model.transaction;

import java.math.BigDecimal;
/*
* Encapsulando e promovendo reusabilidade, se eu precisar validar algum
* outro valor no meu sistema, posso fazer por esta classe.
* */
public class Valor {

    private BigDecimal valor;

    public Valor(BigDecimal valor) {
        validateValue(valor);
        this.valor = valor;
    }

    public static Valor create(BigDecimal valor) {
        return new Valor(valor);
    }

    private void validateValue(BigDecimal input) {
        if (input == null || input.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public BigDecimal getValue() {
        return valor;
    }
}
