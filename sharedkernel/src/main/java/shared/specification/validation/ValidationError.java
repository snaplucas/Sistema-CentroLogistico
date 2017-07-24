package shared.specification.validation;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ValidationError implements Serializable {
	private static final long serialVersionUID = 1L;

	public ValidationError(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public String toString() {
		return "ValidationError - [mensagem=" + mensagem + "]";
	}

}
