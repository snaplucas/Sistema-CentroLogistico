package gateway.specification.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private List<ValidationError> erros;

    public ValidationResult() {
        this.erros = new ArrayList<>();
    }

    public void add(ValidationError erro) {
        this.erros.add(erro);
    }

    public void addAll(List<ValidationError> erros) {
        this.erros.addAll(erros);
    }

    public boolean isValid() {
        return erros.isEmpty();
    }

    public List<ValidationError> getErros() {
        return erros;
    }

}
