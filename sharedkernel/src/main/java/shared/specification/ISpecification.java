package shared.specification;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T entity);
}
