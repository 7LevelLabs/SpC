package ua.ll7.slot21.spc.rs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ll7.slot21.spc.exception.ApplicationException;
import ua.ll7.slot21.spc.exception.ApplicationExportException;
import ua.ll7.slot21.spc.service.IExportDataService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Alex Velichko
 *         05.06.14 : 13:47
 */

/**
 * Export controller
 */
@Controller
@RequestMapping("/spc")
public class ExportController {
	private static final Logger LOGGER = Logger.getLogger(ExportController.class);

	@Autowired
	private IExportDataService exportDataService;

	/**
	 * Export F2 data
	 *
	 * @see ua.ll7.slot21.spc.service.IF2Service#getAllAsCSV()
	 */
	@RequestMapping(value = "export/f2")
	public void exportF2(HttpServletResponse httpServletResponse) throws ApplicationExportException, ApplicationException {
		exportDataService.exportF2(httpServletResponse);
	}
}
