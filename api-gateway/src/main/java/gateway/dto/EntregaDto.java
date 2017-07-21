package gateway.dto;

import java.util.List;

public class EntregaDto {

    private String id;
    private String veiculo;
    private List<PacoteDto> pacotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public List<PacoteDto> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<PacoteDto> pacotes) {
        this.pacotes = pacotes;
    }
}
