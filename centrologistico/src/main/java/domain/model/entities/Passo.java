package domain.model.entities;

import domain.model.enumeradores.Zona;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passo {

    private String pacoteId;
    private Zona de;
    private Zona para;
}
