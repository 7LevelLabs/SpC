package ua.ll7.slot21.spc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         06.06.14 : 12:55
 */
public abstract class ADao<T extends Serializable> {

	@Autowired
	SessionFactory sessionFactory;

	private Class<T> clazz;

	public void create(T data) {
		getCurrentSession().save(data);
	}

	public List<T> getAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public T findById(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public void update(T data) {
		getCurrentSession().update(data);
	}

	// ===

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
