package gateway.specification.validation.interfaces;

public interface IRule<T> {

    boolean validar(T entity);

    String mensagemErro();
}
