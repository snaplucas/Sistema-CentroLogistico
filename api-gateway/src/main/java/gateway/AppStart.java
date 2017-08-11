package gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import gateway.clients.EntregaClient;
import gateway.dto.EntregaDto;
import gateway.dto.PassoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shared.specification.validation.ValidationResult;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@RestController
public class AppStart {

    @Autowired
    private EntregaClient entregaClient;

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

    @RequestMapping(value = "/entrega/{entregaid}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "reliable")
    public List<PassoDto> obterPassos(@PathVariable String entregaid) {
        try {
            return entregaClient.obterPassos(entregaid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/entrega", method = RequestMethod.POST)
    ResponseEntity<ValidationResult> inserirEntrega(@RequestBody EntregaDto entregaDto) {
        try {
            return entregaClient.inserirEntrega(entregaDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
