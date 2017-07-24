package shared.specification.validation.interfaces;


import shared.specification.validation.ValidationResult;

public interface IValidation<T> {

    ValidationResult Validar(T entity);
}
