package weatherInfo.model.util;

import java.util.Calendar;
import java.util.Date;
import java.io.BufferedInputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GetWeatherAPI {
	public static String readUrl(String dateConfig) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
					"http://openAPI.seoul.go.kr:8088/4278436266736363373278657a4958/json/DailyWeatherStation/1/999/" + dateConfig);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i, "UTF-8"));
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
	
	public static String urlConfig(int i) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse("20190501");
		} catch (ParseException e) {
			e.printStackTrace();
		}
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, i);		//날짜 더하기
//            cal.add(Calendar.MONTH, 1);		//월 더하기

//            String varDate = new SimpleDateFormat("yyyyMMdd").format(date);
//	System.out.println("날짜 확인"+format.format(cal.getTime()));
	return format.format(cal.getTime());
	}
}
