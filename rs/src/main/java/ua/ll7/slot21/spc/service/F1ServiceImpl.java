package ua.ll7.slot21.spc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot21.spc.dao.IF1Dao;
import ua.ll7.slot21.spc.model.F1;

import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 15:11
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class F1ServiceImpl implements IF1Service {

	@Autowired
	private IF1Dao f1Dao;

	@Value("${files.delimiter}")
	private String delimiter;

	@Override
	public void create(F1 data) {
		f1Dao.create(data);
	}

	@Override
	public List<F1> getAll() {
		return f1Dao.getAll();
	}

	@Override
	public F1 findById(long id) {
		return f1Dao.findById(id);
	}

	@Override
	public void createAll(List<Long> fData) {
		for (int i = 0; i < fData.size(); i++) {
			create(new F1(fData.get(i)));
		}
	}

	@Override
	public String getAllAsCSV() {
		String result = null;
		List<F1> f1All = getAll();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < f1All.size() - 1; i++) {
			F1 f1 = f1All.get(i);

			sb
				.append(f1.getValue())
				.append(delimiter);
		}

		sb.append(f1All.get(f1All.size() - 1).getValue());

		return sb.toString();
	}


}
