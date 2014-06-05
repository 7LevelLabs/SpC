package ua.ll7.slot21.spc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.ll7.slot21.spc.model.F2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class BLServiceImplIT extends Assert {

	@Autowired
	private IBLService blService;

	@Autowired
	private IF1Service f1Service;

	@Autowired
	private IF2Service f2Service;

//	0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
//	10,5,7,20,4,2,5,2,8,4,16,21,32,5,6,3,78,54,32,1,87,23

	@Test
	public void testMethod1() throws Exception {

		long result1 = blService.method1(1);
		assertEquals(result1, 5);

		long result2 = blService.method1(3);
		assertEquals(result2, 10);
	}

	@Test
	public void testMethod2() throws Exception {

		long v2 = 1;
		long v3 = 2;
		long v4 = 3;

		long result1 = blService.method2(v2, v3, v4);

		F2 f2Last = blService.getLastF2();

		assertEquals(result1, 0L);
		assertEquals(13L, f2Last.getValue());

		v2 = 7;
		v3 = 3;
		v4 = 5;

		result1 = blService.method2(v2, v3, v4);

		f2Last = blService.getLastF2();

		assertEquals(result1, 1L);
		assertEquals(10L, f2Last.getValue());
	}
}