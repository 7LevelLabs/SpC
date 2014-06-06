package ua.ll7.slot21.spc.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         06.06.14 : 12:46
 */

public interface IGenericDao<T extends Serializable> {

	public void create(final T data);

	public List<T> getAll();

	public void update(final T data);

	public T findById(final long id);
}
