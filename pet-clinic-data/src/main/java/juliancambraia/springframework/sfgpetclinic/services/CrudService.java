package juliancambraia.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * Interface Genérica
 *
 * @param <T>
 * @param <ID>
 * @author juliancambraia
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
