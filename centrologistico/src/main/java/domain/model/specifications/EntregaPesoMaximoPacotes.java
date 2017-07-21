package domain.model.specifications;

import domain.model.entities.Entrega;
import domain.model.entities.Pacote;
import port.adapter.specification.ISpecification;

public class EntregaPesoMaximoPacotes implements ISpecification<Entrega> {

    @Override
    public boolean isSatisfiedBy(Entrega entity) {
        return entity.getPacotes().stream().mapToDouble(Pacote::getPeso).sum() < 1000;
    }
}
