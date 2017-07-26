import domain.model.entities.Entrega;
import domain.model.entities.Pacote;
import domain.model.entities.Passo;
import org.junit.Assert;
import org.junit.Test;
import shared.specification.validation.ValidationResult;

import java.util.Arrays;
import java.util.List;

public class EntregaTest {

    @Test
    public void calculaPassosTest() {
        Entrega entrega = new Entrega();
        Pacote pacote1 = new Pacote();
        pacote1.setId("1");
        pacote1.setPeso(14.5);

        Pacote pacote2 = new Pacote();
        pacote2.setId("2");
        pacote2.setPeso(12.15);

        Pacote pacote3 = new Pacote();
        pacote3.setId("3");
        pacote3.setPeso(19.5);
        List<Pacote> pacotes = Arrays.asList(pacote1, pacote2, pacote3);

        entrega.setPacotes(pacotes);
        List<Passo> passos = entrega.definirPassos();
        Assert.assertEquals(passos.size(), 7);
    }

    @Test
    public void EntregaInvalidaTest(){
        Entrega entrega = new Entrega();

        entrega.isValid();
        ValidationResult validationResult = entrega.getValidationResult();
        Assert.assertEquals(validationResult.getErros().size(), 3);
    }

    @Test
    public void EntregaSemPacotesTest(){
        Entrega entrega = new Entrega();
        entrega.setId("1");
        entrega.setVeiculo("2");

        entrega.isValid();
        ValidationResult validationResult = entrega.getValidationResult();
        Assert.assertEquals(validationResult.getErros().size(), 1);
        Assert.assertEquals(validationResult.getErros().get(0).getMensagem(), "entrega deve ter pacotes");
    }
}
