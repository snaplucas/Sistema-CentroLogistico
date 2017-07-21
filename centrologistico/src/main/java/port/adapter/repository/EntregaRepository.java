package port.adapter.repository;

import domain.model.entities.Entrega;
import domain.model.interfaces.IEntregaRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

public class EntregaRepository implements IEntregaRepository {

    private final MongoTemplate mongoTemplate;

    public EntregaRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void adicionarEntrega(Entrega entrega) {
        mongoTemplate.save(entrega);
    }

    @Override
    public Entrega obterEntrega(String id) {
        return mongoTemplate.findById(id, Entrega.class);
    }
}
