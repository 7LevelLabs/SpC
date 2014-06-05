package ua.ll7.slot21.spc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot21.spc.dao.IF2Dao;
import ua.ll7.slot21.spc.model.F1;
import ua.ll7.slot21.spc.model.F2;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 15:14
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class F2ServiceImpl implements IF2Service {

	@Autowired
	private IF2Dao f2Dao;

	@Value("${files.delimiter}")
	private String delimiter;

	@Override
	public void create(F2 data) {
		f2Dao.create(data);
	}

	@Override
	public void update(F2 data) {
		f2Dao.update(data);
	}

	@Override
	public List<F2> getAll() {
		return f2Dao.getAll();
	}

	@Override
	public F2 findById(long id) {
		return f2Dao.findById(id);
	}

	@Override
	public boolean exist(long id) {
		return findById(id)!=null;
	}

	@Override
	public void createAll(List<Long> fData) {
		for (int i = 0; i < fData.size(); i++) {
			create(new F2(fData.get(i)));
		}
	}

	@Override
	public String getAllAsCSV() {
		String result = null;
		List<F2> f2All = getAll();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < f2All.size()-1; i++) {
			F2 f2 = f2All.get(i);

			sb
				.append(f2.getValue())
				.append(delimiter);
		}

		sb.append(f2All.get(f2All.size()-1).getValue());

		return sb.toString();
	}
}
