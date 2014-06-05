package ua.ll7.slot21.spc.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class FileTransferImplIT extends Assert {

	@Autowired
	private FileTransferImpl fileTransfer;

	@Value("${files.f1}")
	private String f1FileName;

	@Test
	public void testFReadDatafile() throws Exception {

		InputStream f1Stream = fileTransfer.fInputStream(f1FileName);

		assertNotNull(f1Stream);

		List<Long> longs = fileTransfer.fReadDatafile(f1Stream);

		LinkedList<Long> longsCreated = new LinkedList<Long>();

		//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
		longsCreated.add(0L);
		longsCreated.add(1L);
		longsCreated.add(2L);
		longsCreated.add(3L);
		longsCreated.add(4L);
		longsCreated.add(5L);
		longsCreated.add(6L);
		longsCreated.add(7L);
		longsCreated.add(8L);
		longsCreated.add(9L);
		longsCreated.add(10L);
		longsCreated.add(11L);
		longsCreated.add(12L);
		longsCreated.add(13L);
		longsCreated.add(14L);
		longsCreated.add(15L);
		longsCreated.add(16L);
		longsCreated.add(17L);
		longsCreated.add(18L);
		longsCreated.add(19L);
		longsCreated.add(20L);

		assertEquals(longs, longsCreated);
	}
}