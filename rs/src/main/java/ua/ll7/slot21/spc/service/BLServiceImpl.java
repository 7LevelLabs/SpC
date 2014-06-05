package ua.ll7.slot21.spc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.ll7.slot21.spc.model.F1;
import ua.ll7.slot21.spc.model.F2;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:23
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BLServiceImpl implements IBLService {

	@Autowired
	private IF1Service f1Service;

	@Autowired
	private IF2Service f2Service;

	private F2 f2 = null;

	/**
	 * 1. Get (v1)
	 *
	 * @param v1
	 */
	@Override
	public long method1(long v1) {
		v1=v1+1L;

		F2 f2 = f2Service.findById(v1);

		if (f2.getValue()>10) {
			f2.setValue(10L);
		}

		return f2.getValue();
	}

	/**
	 * 2. Post (v2,v3,v4)
	 *
	 * @param v2
	 * @param v3
	 * @param v4
	 */
	@Override
	public long method2(long v2, long v3, long v4) {

		v3 = v3+1L;
		v4 = v4+1L;

		long result = 0L;

		F1 f1 = f1Service.findById(v3);

		f2 = f2Service.findById(v4);

		if ((f1.getValue()+v2) < 10L) {
			f2.setValue(f1.getValue()+v2+10L);
		}
		else {
			f2.setValue(f1.getValue()+v2);
			result = 1L;
		}

		f2Service.update(f2);

		return result;
	}

	public F2 getLastF2() {
		return f2;
	}
}
