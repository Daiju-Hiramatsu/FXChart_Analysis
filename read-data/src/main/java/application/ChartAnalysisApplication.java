package main.java.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.java.commons.CommonException;
import main.java.constants.ErrMessageConstant;
import main.java.constants.NumericConstant;
import main.java.constants.UrlConstant;
import main.java.function.url.UrlResourceHandler;

public class ChartAnalysisApplication {

	public static void main(String[] args) throws CommonException {
		//URLとCHARSETを初めに設定しておく。
		UrlResourceHandler handler = new UrlResourceHandler(UrlConstant.URL, UrlConstant.CHARSET);
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("HHmmss");
		while(true) {
			LocalDateTime nowDateTime = LocalDateTime.now();
			int nowTime = Integer.parseInt(dtFormat.format(nowDateTime));
			if (nowTime <= 190200) {
				String targetLine = handler.urlRead();
				System.out.println(nowTime + " : " + targetLine);
				try {
					Thread.sleep(NumericConstant.SLEEP_TIME);
				} catch (InterruptedException e) {
					throw new CommonException(ErrMessageConstant.E000001, e);
				}
			} else {
				break;
			}
		}
		//読み取ったら、そのドル円の情報を引っ張ってくる。
		//handler.getTargetValueFromLine(targetLine, ",");
		
		//リストからbiｄを含む文字列を引っ張ってきて数字だけを抽出する。
		
		//Mapなどを使って複数回のドル円情報を格納
		//格納した情報から全体の近似直線と最近の近似直線を見る
		//全体の近似直線（A）と最近の近似直線（B）のそれぞれMapなどに格納
		
	}

}
