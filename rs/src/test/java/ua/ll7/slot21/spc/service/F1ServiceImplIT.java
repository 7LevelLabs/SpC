package ua.ll7.slot21.spc.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import ua.ll7.slot21.spc.model.F1;
import ua.ll7.slot21.spc.util.IFileTransfer;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class F1ServiceImplIT extends Assert {

	@Autowired
	private IF1Service f1Service;

	@Test
	public void testCreateAll() throws Exception {

		//setUp local
		List<Long> longs = new LinkedList<Long>();

		for (long i = 0; i < 20; i++) {
			longs.add(i);
		}

		//action
		f1Service.createAll(longs);

		//assert
		List<F1> result = f1Service.getAll();

		org.assertj.core.api.Assertions.assertThat(result)
			.isNotEmpty()
			.hasSize(41);
	}
}