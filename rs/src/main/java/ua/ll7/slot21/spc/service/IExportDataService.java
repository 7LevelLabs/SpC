package ua.ll7.slot21.spc.service;

import org.springframework.stereotype.Service;
import ua.ll7.slot21.spc.exception.ApplicationException;
import ua.ll7.slot21.spc.exception.ApplicationExportException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alex Velichko
 *         05.06.14 : 12:55
 */
@Service
public interface IExportDataService {
	/**
	 * Export F2 data to file
	 */
	public void exportF2(HttpServletResponse httpResponse) throws ApplicationExportException,ApplicationException;

	/**
	 * Export string to file
	 */
	public void exportData(String dataToExport, HttpServletResponse httpResponse) throws IOException;
}
