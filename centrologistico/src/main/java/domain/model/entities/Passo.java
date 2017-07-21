package domain.model.entities;

import domain.model.enumeradores.Zona;

public class Passo {

    private String pacoteId;
    private Zona de;
    private Zona para;

    public Passo(String pacoteId, Zona de, Zona para) {
        this.pacoteId = pacoteId;
        this.de = de;
        this.para = para;
    }

    public String getPacoteId() {
        return pacoteId;
    }

    public Zona getDe() {
        return de;
    }

    public Zona getPara() {
        return para;
    }
}
