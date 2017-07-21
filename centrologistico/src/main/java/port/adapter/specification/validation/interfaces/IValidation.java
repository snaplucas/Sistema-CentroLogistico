package port.adapter.specification.validation.interfaces;


import port.adapter.specification.validation.ValidationResult;

public interface IValidation<T> {

    ValidationResult Validar(T entity);
}
