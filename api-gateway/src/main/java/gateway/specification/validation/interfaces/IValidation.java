package gateway.specification.validation.interfaces;


import gateway.specification.validation.ValidationResult;

public interface IValidation<T> {

    ValidationResult Validar(T entity);
}
