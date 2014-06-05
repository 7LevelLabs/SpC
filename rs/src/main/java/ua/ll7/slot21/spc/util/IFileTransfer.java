package ua.ll7.slot21.spc.util;

import org.springframework.stereotype.Component;
import ua.ll7.slot21.spc.exception.ApplicationDataLoadException;
import ua.ll7.slot21.spc.exception.ApplicationException;

/**
 * @author Alex Velichko
 *         03.06.14 : 11:47
 */
@Component
public interface IFileTransfer {
	/**
	 * Initial loading data from the data files
	 */
	public void loadData() throws ApplicationDataLoadException, ApplicationException;
}
