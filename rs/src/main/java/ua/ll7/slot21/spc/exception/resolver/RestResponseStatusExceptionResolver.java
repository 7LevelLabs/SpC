package ua.ll7.slot21.spc.exception.resolver;

import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Alex Velichko
 *         03.06.14 : 12:58
 */
@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(javax.servlet.http.HttpServletRequest request,
							javax.servlet.http.HttpServletResponse response,
							Object handler,
							Exception ex) {

		try {

			if (ex instanceof CannotCreateTransactionException) {
				return handleCannotCreateTransactionException((CannotCreateTransactionException) ex,
					response,
					handler);
			}

		} catch (Exception handlerException) {
			logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
		}

		return null;
	}

	private ModelAndView handleCannotCreateTransactionException(CannotCreateTransactionException ex,
									    HttpServletResponse response,
									    Object handler) throws IOException {

		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		return new ModelAndView();
	}
}
