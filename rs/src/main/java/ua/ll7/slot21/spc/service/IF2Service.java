package ua.ll7.slot21.spc.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot21.spc.model.F2;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 15:13
 */
@Service
public interface IF2Service {
	public void create(F2 data);
	public void update(F2 data);
	public List<F2> getAll();
	public F2 findById(long id);
	public boolean exist(long id);

	public void createAll(List<Long> fData);

	public String getAllAsCSV();

}
