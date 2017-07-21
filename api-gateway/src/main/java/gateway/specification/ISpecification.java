package gateway.specification;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T entity);
}
