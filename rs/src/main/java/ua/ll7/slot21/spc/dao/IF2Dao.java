package ua.ll7.slot21.spc.dao;

import org.springframework.stereotype.Repository;
import ua.ll7.slot21.spc.model.F2;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:06
 */
@Repository
public interface IF2Dao {
	public void create(F2 data);
	public void update(F2 data);
	public List<F2> getAll();
	public F2 findById(long id);
}
