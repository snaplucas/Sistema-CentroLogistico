package domain.model.interfaces;

import domain.model.entities.Entrega;

public interface IEntregaRepository {

    void adicionarEntrega(Entrega entrega);

    Entrega obterEntrega(String id);
}
