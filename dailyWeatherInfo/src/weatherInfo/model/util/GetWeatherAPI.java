package weatherInfo.model.util;

import java.io.BufferedInputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
<<<<<<< HEAD
import weatherInfo.model.dao.DayWeatherDAO;

public class GetWeatherAPI {
	public static JSON readUrl(String dateConfig) throws Exception {

		BufferedInputStream reader = null;
		String result = null;
		try {
			URL url = new URL(
					"http://openAPI.seoul.go.kr:8088/79596d537668617032376245675851/json/DailyWeatherStation/1/999/" + dateConfig);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i, "UTF-8"));
			}

			 result =  buffer.toString();
			  JSONObject obj = JSONObject.fromObject(result);
			  return obj;
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
            cal.add(Calendar.DATE, i);		

	return format.format(cal.getTime());
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 90; i++) {
			DayWeatherDAO.addDayWeatherData(JsonToWeather.JSONToWeatherData(getWeatherData(urlConfig(i))));
		}

	}
}
