package ua.ll7.slot21.spc.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ua.ll7.slot21.spc.exception.ApplicationDataLoadException;
import ua.ll7.slot21.spc.exception.ApplicationException;
import ua.ll7.slot21.spc.service.IF1Service;
import ua.ll7.slot21.spc.service.IF2Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:13
 */

/**
 * Initial dataload
 *
 * @see ua.ll7.slot21.spc.exception.ApplicationDataLoadException
 * @see ua.ll7.slot21.spc.exception.ApplicationException
 */
@Component
public class FileTransferImpl implements IFileTransfer {

	private static final Logger LOGGER = Logger.getLogger(FileTransferImpl.class);

	@Autowired
	private IF1Service f1Service;

	@Autowired
	private IF2Service f2Service;

	@Value("${files.f1}")
	private String f1FileName;

	@Value("${files.f2}")
	private String f2FileName;

	@Value("${files.dir}")
	private String datafilesDir;

	@Value("${files.delimiter}")
	private String datafilesDelimiter;

	@Value("${context.path}")
	private String contextPath;

	@PostConstruct
	public void init() throws ApplicationDataLoadException, ApplicationException {
		loadData();
	}

	/**
	 * Initial loading data from the data files
	 */
	@Override
	public void loadData() throws ApplicationDataLoadException, ApplicationException {

		try {

			//F1
			LOGGER.info("Load dafa F1[x] : " + f1FileName);

			InputStream f1Stream = fInputStream(f1FileName);
			List<Long> f1Data = fReadDatafile(f1Stream);
			f1Service.createAll(f1Data);
			LOGGER.info("Done");

			//F2
			LOGGER.info("Load dafa F2[x] : " + f2FileName);

			InputStream f2Stream = fInputStream(f2FileName);
			List<Long> f2Data = fReadDatafile(f2Stream);
			f2Service.createAll(f2Data);
			LOGGER.info("Done");

		} catch (IOException e) {
			LOGGER.error("IO Error during load data : " + e);
			throw new ApplicationDataLoadException("IO Error during load data. Please check initial datafiles in the server filesystem and restart application.");
		} catch (NumberFormatException e) {
			LOGGER.error("NumberFormat Error during load data : " + e);
			throw new ApplicationDataLoadException("Number format Error during load data. Please check initial datafiles for data consistency and restart application.");
		} catch (Exception e) {
			LOGGER.error("An Error during load data : " + e);
			throw new ApplicationException("An Error during load data. Please restart application.");
		}
	}

	public List<Long> fReadDatafile(InputStream is) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		LinkedList<Long> resultList = new LinkedList<Long>();
		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, datafilesDelimiter);
			while (st.hasMoreElements()) {
				resultList.add(Long.valueOf(st.nextToken()));
			}
		}

		br.close();
		return resultList;
	}

	public InputStream fInputStream(String datafileName) throws IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:" +
			File.separator +
			contextPath);

		Resource resource = appContext.getResource("classpath:" +
			File.separator +
			datafilesDir +
			File.separator +
			datafileName);

		return resource.getInputStream();
	}
}
