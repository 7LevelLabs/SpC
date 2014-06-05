package ua.ll7.slot21.spc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.ll7.slot21.spc.model.F2;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class F2ServiceImplIT extends Assert {

	@Autowired
	private IF2Service f2Service;

	@Test
	public void testUpdate() throws Exception {
		F2 f2 = f2Service.findById(1);
		f2.setValue(7);

		f2Service.update(f2);

		F2 f2Read = f2Service.findById(1);

		assertEquals(f2Read.getValue(),7);
	}

	@Test
	public void testGetAll() throws Exception {
		List<F2> f2All = f2Service.getAll();

		org.assertj.core.api.Assertions.assertThat(f2All)
			.isNotEmpty()
			.hasSize(22);
	}

	@Test
	public void testGetAllAsCSV() throws Exception {
		String f2AllAsString = f2Service.getAllAsCSV();

		assertEquals(
			f2AllAsString,
			"10,5,7,20,4,2,5,2,8,4,16,21,32,5,6,3,78,54,32,1,87,23");
	}

}