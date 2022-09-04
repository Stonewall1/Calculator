package by.tms.storage;

public interface CrudDao<T> {
    T save(T e);
}
