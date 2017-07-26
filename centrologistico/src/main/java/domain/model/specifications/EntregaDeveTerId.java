package domain.model.specifications;

import domain.model.entities.Entrega;
import org.apache.commons.lang.StringUtils;
import shared.specification.ISpecification;

public class EntregaDeveTerId implements ISpecification<Entrega> {

    @Override
    public boolean isSatisfiedBy(Entrega entity) {
        return StringUtils.isNotEmpty(entity.getId());
    }
}
