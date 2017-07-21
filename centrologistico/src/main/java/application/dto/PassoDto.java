package application.dto;

import domain.model.enumeradores.Zona;

public class PassoDto {

    private String pacoteId;
    private Zona de;
    private Zona para;

    public String getPacoteId() {
        return pacoteId;
    }

    public void setPacoteId(String pacoteId) {
        this.pacoteId = pacoteId;
    }

    public Zona getDe() {
        return de;
    }

    public void setDe(Zona de) {
        this.de = de;
    }

    public Zona getPara() {
        return para;
    }

    public void setPara(Zona para) {
        this.para = para;
    }
}
