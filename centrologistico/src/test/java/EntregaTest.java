import domain.model.entities.Entrega;
import domain.model.entities.Pacote;
import domain.model.entities.Passo;
import org.junit.Assert;
import org.junit.Test;

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
}
