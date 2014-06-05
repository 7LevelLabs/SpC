package ua.ll7.slot21.spc.dao;

import org.springframework.stereotype.Repository;
import ua.ll7.slot21.spc.model.F1;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 11:55
 */
@Repository
public interface IF1Dao {
	public void create(F1 data);
	public List<F1> getAll();
	public F1 findById(long id);
}
