package weatherInfo.model.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import weatherInfo.model.dao.DayAirPollutionDAO;

public class GetAirPollutionAPI {

	public static JSON getAirPollutionData(String dateConfig) {
		BufferedReader br = null;
		String result = "";
		JSONObject obj = null;
		String url = null;
		try {
			url = "http://openAPI.seoul.go.kr:8088/797a42666568617038304266515253/json/DailyAverageAirQuality/1/999/"
					+ dateConfig;
			URL urlstr = new URL(url);
			HttpURLConnection urlconnection = (HttpURLConnection) urlstr.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

			String line;
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
			obj = JSONObject.fromObject(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obj;
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
			cal.add(Calendar.DATE, i); // 날짜 더하기

			return format.format(cal.getTime());
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 90; i++) {
			DayAirPollutionDAO.addDayAirPollution(JsonToAirPollution.JSONToAirPollutionData(getAirPollutionData(urlConfig(i))));
		}
	}
}
