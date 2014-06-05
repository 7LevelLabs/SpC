package ua.ll7.slot21.spc.rs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ll7.slot21.spc.service.IF1Service;
import ua.ll7.slot21.spc.service.IF2Service;
import ua.ll7.slot21.spc.util.response.FResponse;

/**
 * @author Alex Velichko
 *         05.06.14 : 18:08
 */
@Controller
@RequestMapping("/spc")
public class FDataController {

	private static final Logger LOGGER = Logger.getLogger(SpCController.class);

	@Autowired
	private IF1Service f1Service;

	@Autowired
	private IF2Service f2Service;

	@RequestMapping(value = "/getFDataAsString/{arg}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<FResponse> getFDataAsString(
		@PathVariable("arg")
		int arg
	) {

		if (arg != 1) {
			LOGGER.warn("Inappropriate arg : " + arg);
			return new ResponseEntity<FResponse>(HttpStatus.NOT_ACCEPTABLE);
		}

		if (arg != 2) {
			LOGGER.warn("Inappropriate arg : " + arg);
			return new ResponseEntity<FResponse>(HttpStatus.NOT_ACCEPTABLE);
		}

		String data = null;

		if (arg == 1) {
			data = f1Service.getAllAsCSV();
		} else {
			data = f2Service.getAllAsCSV();
		}
		FResponse result = new FResponse(data);
		return new ResponseEntity<FResponse>(result, HttpStatus.OK);
	}

}
