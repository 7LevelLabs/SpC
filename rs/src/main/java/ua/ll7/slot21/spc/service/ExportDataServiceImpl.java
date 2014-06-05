package ua.ll7.slot21.spc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ua.ll7.slot21.spc.exception.ApplicationException;
import ua.ll7.slot21.spc.exception.ApplicationExportException;
import ua.ll7.slot21.spc.util.Constants;
import ua.ll7.slot21.spc.util.DateUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @author Alex Velichko
 *         05.06.14 : 13:00
 */
@Service
public class ExportDataServiceImpl implements IExportDataService {

	private static final Logger LOGGER = Logger.getLogger(ExportDataServiceImpl.class);

	@Autowired
	private IF2Service f2Service;

	/**
	 * Export F2 data to file
	 *
	 * @param httpResponse Servlet response to export to
	 */
	@Override
	public void exportF2(HttpServletResponse httpResponse) throws ApplicationExportException, ApplicationException {

		try {

			exportData(f2Service.getAllAsCSV(), httpResponse);

		} catch (IOException e) {
			LOGGER.error("IO Error during export data : " + e);
			throw new ApplicationExportException("IO Error during export data. Please check server filesystem.");
		} catch (Exception e) {
			LOGGER.error("An Error during export data : " + e);
			throw new ApplicationException("An Error during export data.");
		}

	}

	/**
	 * Export data to file (servlet response)
	 *
	 * @param dataToExport String to export
	 * @param httpResponse Servlet response to export to
	 */
	@Override
	public void exportData(String dataToExport, HttpServletResponse httpResponse) throws IOException {
		File tmpFile = File.createTempFile("f2-export-", ".csv");
		String fileName = "F2_export_" + DateUtils.formatExportData(new Date()) + ".csv";

		writeExportDataToTmpFile(dataToExport, tmpFile);

		writeExportDataToResponse(httpResponse, tmpFile, fileName);
	}

	/**
	 * Write string to the file. File must exist.
	 *
	 * @param dataToExport String to wtite
	 * @param tmpFile      File to write to. <b>This file must exist.<b/>
	 */
	private void writeExportDataToTmpFile(String dataToExport, File tmpFile) throws IOException {

		FileWriter fileWriter = new FileWriter(tmpFile);

		fileWriter.write(dataToExport);
		fileWriter.close();
	}

	/**
	 * Write content of tmpFile to servlet response and assign appropriate filename.
	 *
	 * @param httpResponse Servlet response to write to
	 * @param tmpFile      Tmp file with content
	 * @param fileName     File name to assign to user-downloaded file
	 */
	private void writeExportDataToResponse(HttpServletResponse httpResponse,
						    File tmpFile,
						    String fileName) throws IOException {

		httpResponse.setContentType(Constants.CSV_CONTENT_TYPE);
		httpResponse.setContentLength(Long.valueOf(tmpFile.length()).intValue());
		httpResponse.setHeader(Constants.CONTENT_DISPOSITION_HEADER, Constants.CONTENT_DISPOSITION_VALUE_PATTERN.replaceFirst(Constants.FILE_NAME_PLACE_HOLDER, fileName));
		httpResponse.setCharacterEncoding(Constants.DEFAULT_ENCODING);

		FileCopyUtils.copy(new FileInputStream(tmpFile), httpResponse.getOutputStream());
	}
}
