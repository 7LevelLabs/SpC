package ua.ll7.slot21.spc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ll7.slot21.spc.model.F1;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 13:58
 */
@Repository
public class F1DaoImpl implements IF1Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(F1 data) {
		Session session = sessionFactory.getCurrentSession();
		session.save(data);
	}

	@Override
	public List<F1> getAll() {
		List<F1> result = null;
		Session session = sessionFactory.getCurrentSession();
		result = session.createCriteria(F1.class).list();
		return result;
	}

	@Override
	public F1 findById(long id) {

		F1 result = null;

		Session session = sessionFactory.getCurrentSession();

		String selectString =
			"select result " +
				"from F1 as result " +
				"where result.id = :id";

		Query query = session.createQuery(selectString);
		query.setParameter("id", id);

		result = (F1) query.uniqueResult();

		return result;
	}
}
