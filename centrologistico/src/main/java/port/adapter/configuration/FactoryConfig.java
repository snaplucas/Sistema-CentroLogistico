package port.adapter.configuration;

import application.interfaces.IEntregaAppService;
import application.services.EntregaAppService;
import domain.model.interfaces.IEntregaRepository;
import domain.model.interfaces.IEntregaService;
import domain.model.services.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import port.adapter.repository.EntregaRepository;

@Configuration
public class FactoryConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public IEntregaAppService getEntregaAppService() {
        return new EntregaAppService(getEntregaService());
    }

    @Bean
    public IEntregaService getEntregaService() {
        return new EntregaService(getEntregaRepository());
    }

    @Bean
    public IEntregaRepository getEntregaRepository() {
        return new EntregaRepository(mongoTemplate);
    }

}
