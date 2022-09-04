package main.java.constants;

/*
 * Define Error_Messeges of this application.
 * 
 * Conversion of constants in this classs.
 *  eXXYYZZ...
 *   XX .. Outline package number.(example: [main.java.applicaiton = 00] [main.java.function = 01])
 *   YY .. District number of package.(example: [main.java.function.url = 01])
 *   ZZ .. Error number of belong district. 
 * */
public class ErrMessageConstant {
	
	// error test.
	public static final String E000001 = "Cannot collectly done thread_sleep.";
	
	// case of MalformedURLException occurred by URLConnection.
	public static final String E010101 = "The URL maybe wrong. Please check it now.";
	
	// case of IOException occurred by URLConnection.
	public static final String E010102 = "Cannot connect target URL by IOException.";

	// case of IOException occurred by getInputStream.
	public static final String E010103 = "Cannot Create InputStream by IOException.";
	
	// case of UnsupportedEncodingException occurred by InputStreamReader.
	public static final String E010104 = "Cannot supported the target charset.";
	
	// case of IOException occurred by BufferedReader.readline.
	public static final String E010105 = "Cannot readline from BufferedReader by IOException.";
}
