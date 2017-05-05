package main.java.dao;

import java.util.Collection;

/**
 * Created by vadim on 24.04.2017.
 */
public interface Dao<PK, E> {

    Collection<E> getAll();

    E getById(PK id);

    PK insert(E entity);

    void update(E entity);

    void delete(int id);
}
