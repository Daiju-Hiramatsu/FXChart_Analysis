package main.java.function.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import main.java.commons.CommonException;
import main.java.constants.ErrMessageConstant;
import main.java.constants.UrlConstant;

/*
 * get html from target site and handle theses resources.
 * */
public class UrlResourceHandler {
	// Variable to store URL
	private String url;
	// Variable to store CHARSET
	private String charset;

	public UrlResourceHandler(String url, String charset) {
		this.url = url;
		this.charset = charset;
	}

	/*
	 * get HTML to use URLConnection class and return HTML contents.
	 * */
	public String urlRead() throws CommonException {
		// connect URL.
		URLConnection urlConn;
		try {
			urlConn = new URL(url).openConnection();
		} catch (MalformedURLException e) {
			throw new CommonException(ErrMessageConstant.E010101, e);
		} catch (IOException e) {
			throw new CommonException(ErrMessageConstant.E010102, e);
		}
		// get HTML from site.
		InputStream is;
		try {
			is = urlConn.getInputStream();
		} catch (IOException e) {
			throw new CommonException(ErrMessageConstant.E010103, e);
		}
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(is, charset);
		} catch (UnsupportedEncodingException e) {
			throw new CommonException(ErrMessageConstant.E010104, e);
		}
		String targetLine = null;
		try (BufferedReader br = new BufferedReader(isr)) {
			String line;
			while ((line = br.readLine()) != null) {
				//if you want to exclude unnecessary line, define processing here.
				if (line.contains(UrlConstant.SQUEEZE_STR) && line.contains(UrlConstant.TARGET_FX)) {
					targetLine = line;
					break;
				}
			}
		} catch (IOException e) {
			throw new CommonException(ErrMessageConstant.E010105, e);
		}
		return targetLine;
	}
	
	/*
	 * get element that contain "targetStr" in "line". 
	 * This method is primarily used for get value of ASK or BID by argument "line".
	 */
	public String getTargetValueFromLine(String line, String targetStr) throws CommonException {
		//HTML retrieved from the site we used is separated elements with commas.
		List<String> lineSplit = Arrays.asList(line.split(","));
		String returnVal = null;
		for(String col : lineSplit) {
			if (col.contains(targetStr)) returnVal = col;
		}
		if (returnVal != null) {
			
		} else {
			throw new CommonException(ErrMessageConstant.E010105);
		}
		return returnVal;
	}
}
