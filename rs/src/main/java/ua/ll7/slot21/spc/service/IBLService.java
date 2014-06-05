package ua.ll7.slot21.spc.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot21.spc.model.F2;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:18
 */

/**
 * Business logic for the task
 */
@Service
public interface IBLService {

	/**
	 * 1. Get (v1)
	 */
	public long method1(long v1);

	/**
	 * 2. Post (v2,v3,v4)
	 */
	public long method2(long v2, long v3, long v4);

	/**
	 * 2. Get last F2 (after updating)
	 */
	public F2 getLastF2();

}
