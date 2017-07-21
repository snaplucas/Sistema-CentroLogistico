package port.adapter.specification;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T entity);
}
