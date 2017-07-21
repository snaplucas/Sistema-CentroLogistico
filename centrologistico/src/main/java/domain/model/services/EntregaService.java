package domain.model.services;

import domain.model.entities.Entrega;
import domain.model.interfaces.IEntregaRepository;
import domain.model.interfaces.IEntregaService;

public class EntregaService implements IEntregaService {

    private final IEntregaRepository entregaRepository;

    public EntregaService(IEntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public void adicionarEntrega(Entrega entrega) {
        entregaRepository.adicionarEntrega(entrega);
    }

    @Override
    public Entrega obterEntrega(String id) {
        return entregaRepository.obterEntrega(id);
    }
}
