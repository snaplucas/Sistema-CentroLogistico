package domain.model.entities;

import domain.model.enumeradores.Zona;
import domain.model.validations.EntregaValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import shared.specification.validation.ValidationResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Entrega {

    private String id;
    private String veiculo;
    private List<Pacote> pacotes;

    @Transient
    private List<Passo> passos;

    @Transient
    private ValidationResult validationResult;

    public Entrega() {
        this.pacotes = new ArrayList<>();
        this.passos = new ArrayList<>();
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public boolean isValid() {
        validationResult = new EntregaValidation().Validar(this);
        return validationResult.isValid();
    }

    public List<Passo> definirPassos() {
        pacotes.sort(Comparator.comparingDouble(Pacote::getPeso).reversed());
        resolverPassos(pacotes, Zona.ABASTECIMENTO, Zona.TRANSFERENCIA, Zona.CAMINHAO);
        return passos;
    }

    private void resolverPassos(List<Pacote> pacotes, Zona inicial, Zona auxiliar, Zona destino) {
        if (pacotes.size() == 1) {
            passos.add(new Passo(pacotes.get(0).getId(), inicial, destino));
        } else {
            resolverPassos(pacotes.subList(1, pacotes.size()), inicial, destino, auxiliar);
            passos.add(new Passo(pacotes.get(0).getId(), inicial, destino));
            resolverPassos(pacotes.subList(1, pacotes.size()), auxiliar, inicial, destino);
        }
    }
}
