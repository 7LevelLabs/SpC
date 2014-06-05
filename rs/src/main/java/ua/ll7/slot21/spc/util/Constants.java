package ua.ll7.slot21.spc.util;

/**
 * @author Alex Velichko
 *         05.06.14 : 13:19
 */
public class Constants {
	public static final String CSV_CONTENT_TYPE = "application/vnd.ms-excel";
	public static final String CONTENT_DISPOSITION_HEADER = "Content-Disposition";
	public static final String CONTENT_DISPOSITION_VALUE_PATTERN = "attachment; filename=\"" + Constants.FILE_NAME_PLACE_HOLDER + "\"";
	public static final String FILE_NAME_PLACE_HOLDER = "<fileNamePlaceHolder>";
	public static final String DEFAULT_ENCODING = "UTF-8";

	private Constants(){}

}
