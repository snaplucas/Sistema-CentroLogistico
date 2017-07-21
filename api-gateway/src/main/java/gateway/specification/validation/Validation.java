package gateway.specification.validation;

import gateway.specification.validation.interfaces.IRule;
import gateway.specification.validation.interfaces.IValidation;

import java.util.HashMap;
import java.util.Map;

public class Validation<T> implements IValidation<T> {

    private final Map<String, IRule<T>> validacoesRegras;

    protected Validation() {
        this.validacoesRegras = new HashMap<>();
    }

    public ValidationResult Validar(T entity) {

        ValidationResult resultado = new ValidationResult();

        for (String key : validacoesRegras.keySet()) {

            IRule<T> regra = validacoesRegras.get(key);
            if (!regra.validar(entity)) {
                resultado.add(new ValidationError(regra.mensagemErro()));
            }
        }
        return resultado;
    }

    public void add(String nome, IRule<T> regra) {
        String nomeRegra = regra.getClass() + nome;
        validacoesRegras.put(nomeRegra, regra);
    }

}
