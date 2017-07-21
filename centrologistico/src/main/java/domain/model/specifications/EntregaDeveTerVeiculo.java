package domain.model.specifications;

import domain.model.entities.Entrega;
import org.apache.commons.lang.StringUtils;
import port.adapter.specification.ISpecification;

public class EntregaDeveTerVeiculo implements ISpecification<Entrega> {

    @Override
    public boolean isSatisfiedBy(Entrega entity) {
        return StringUtils.isNotEmpty(entity.getVeiculo());
    }
}
