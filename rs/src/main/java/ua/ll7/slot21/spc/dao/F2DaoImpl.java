package ua.ll7.slot21.spc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot21.spc.model.F2;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 14:15
 */
@Repository
public class F2DaoImpl implements IF2Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void create(F2 data) {
		Session session = sessionFactory.getCurrentSession();
		session.save(data);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void update(F2 data) {
		Session session = sessionFactory.getCurrentSession();
		session.update(data);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<F2> getAll() {
		List<F2> result = null;
		Session session = sessionFactory.getCurrentSession();
		result = session.createCriteria(F2.class).list();
		return result;
	}

	@Override
	public F2 findById(long id) {

		F2 result = null;

		Session session = sessionFactory.getCurrentSession();

		String selectString =
			"select result " +
				"from F2 as result " +
				"where result.id = :id";

		Query query = session.createQuery(selectString);
		query.setParameter("id", id);

		result = (F2) query.uniqueResult();

		return result;
	}
}
