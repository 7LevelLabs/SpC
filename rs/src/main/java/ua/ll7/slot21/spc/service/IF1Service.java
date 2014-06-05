package ua.ll7.slot21.spc.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot21.spc.model.F1;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 15:10
 */
@Service
public interface IF1Service {
	public void create(F1 data);
	public List<F1> getAll();
	public F1 findById(long id);

	public void createAll(List<Long> fData);
}
