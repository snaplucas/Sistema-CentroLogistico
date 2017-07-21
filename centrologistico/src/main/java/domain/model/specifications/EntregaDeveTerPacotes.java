package domain.model.specifications;

import domain.model.entities.Entrega;
import port.adapter.specification.ISpecification;

public class EntregaDeveTerPacotes implements ISpecification<Entrega> {

    @Override
    public boolean isSatisfiedBy(Entrega entity) {
        return entity.getPacotes().size() > 0;
    }
}
