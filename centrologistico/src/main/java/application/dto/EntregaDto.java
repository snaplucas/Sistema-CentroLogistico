package application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EntregaDto {

    private String id;
    private String veiculo;
    private List<PacoteDto> pacotes;
}
