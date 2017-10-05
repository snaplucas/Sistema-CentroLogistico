package application.dto;

import domain.model.enumeradores.Zona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassoDto {

    private String pacoteId;
    private Zona de;
    private Zona para;
}
