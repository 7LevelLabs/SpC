package ua.ll7.slot21.spc.rs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ll7.slot21.spc.service.IBLService;
import ua.ll7.slot21.spc.service.IF2Service;
import ua.ll7.slot21.spc.util.response.MethodResponse;
import ua.ll7.slot21.spc.util.request.Method2Request;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:32
 */

/**
 * Business actions controller
 */
@Controller
@RequestMapping("/spc")
public class SpCController {

	private static final Logger logger = Logger.getLogger(SpCController.class);

	@Autowired
	private IBLService blService;

	@Autowired
	private IF2Service f2Service;

	/**
	 * 1. Get (v1)
	 *
	 * @see ua.ll7.slot21.spc.service.IBLService#method1(long)
	 */
	@RequestMapping(value = "/method1/{v1}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<MethodResponse> method1(
		@PathVariable("v1")
		long v1
	) {
		if (!f2Service.exist(v1)) {
			logger.warn("Not found : " + v1);
			return new ResponseEntity<MethodResponse>(HttpStatus.NOT_FOUND);
		}

		MethodResponse result = new MethodResponse(blService.method1(v1));
		return new ResponseEntity<MethodResponse>(result, HttpStatus.OK);
	}

	/**
	 * 2. Post (v2,v3,v4)
	 *
	 * @see ua.ll7.slot21.spc.service.IBLService#method2(long, long, long)
	 */
	@RequestMapping(value = "/method2",
		method = RequestMethod.POST,
		produces = MediaType.APPLICATION_XML_VALUE,
		consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<MethodResponse> method2(
		@RequestBody
		Method2Request request
	) {

		if (request == null) {
			return new ResponseEntity<MethodResponse>(HttpStatus.NOT_ACCEPTABLE);
		}

		MethodResponse result = new MethodResponse(blService.method2(request.getV1(), request.getV2(), request.getV3()));
		return new ResponseEntity<MethodResponse>(result, HttpStatus.OK);
	}
}
