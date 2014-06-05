package ua.ll7.slot21.spc.util;

/**
 * @author Alex Velichko
 *         05.06.14 : 13:04
 */

import org.apache.commons.lang3.time.DateFormatUtils;
import java.util.Date;

/**
 * Date utils. Static use only.
 */
public class DateUtils {
	private static final String COMMON_EXPORT_DATETIME_FORMAT = "dd-MM-yyyy-HH-mm";

	/**
	 * Static use only
	 */
	private DateUtils() {
	}

	public static String formatExportData(Date date) {
		return DateFormatUtils.format(date, COMMON_EXPORT_DATETIME_FORMAT);
	}
}
