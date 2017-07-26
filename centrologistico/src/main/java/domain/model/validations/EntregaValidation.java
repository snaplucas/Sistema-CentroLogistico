package domain.model.validations;

import domain.model.entities.Entrega;
import domain.model.specifications.EntregaDeveTerId;
import domain.model.specifications.EntregaDeveTerPacotes;
import domain.model.specifications.EntregaDeveTerVeiculo;
import domain.model.specifications.EntregaPesoMaximoPacotes;
import shared.specification.validation.Rule;
import shared.specification.validation.Validation;

public class EntregaValidation extends Validation<Entrega> {

    public EntregaValidation() {
        EntregaDeveTerId id = new EntregaDeveTerId();
        EntregaDeveTerVeiculo veiculo = new EntregaDeveTerVeiculo();
        EntregaDeveTerPacotes pacotes = new EntregaDeveTerPacotes();
        EntregaPesoMaximoPacotes peso = new EntregaPesoMaximoPacotes();

        super.add("id", new Rule<>(id, "entrega deve ter id"));
        super.add("veiculo", new Rule<>(veiculo, "entrega deve ter veiculo"));
        super.add("pacotes", new Rule<>(pacotes, "entrega deve ter pacotes"));
        super.add("peso", new Rule<>(peso, "limite maximo de peso excedido"));
    }
}
