package ua.ll7.slot21.spc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot21.spc.dao.IF1Dao;
import ua.ll7.slot21.spc.model.F1;

import java.util.Iterator;
import java.util.List;

/**
 * @author Alex Velichko
 *         03.06.14 : 15:11
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class F1ServiceImpl implements IF1Service {

	@Autowired
	private IF1Dao f1Dao;

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



}
