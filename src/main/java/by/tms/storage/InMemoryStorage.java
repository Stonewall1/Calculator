package by.tms.storage;

import java.util.List;

public interface InMemoryStorage<T> extends CrudDao<T>{
    List<T> getElements();
}
