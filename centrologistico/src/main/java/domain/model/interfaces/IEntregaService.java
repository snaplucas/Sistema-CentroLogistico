package domain.model.interfaces;

import domain.model.entities.Entrega;

public interface IEntregaService {

    void adicionarEntrega(Entrega entrega);

    Entrega obterEntrega(String id);
}
