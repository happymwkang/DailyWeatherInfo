package weatherInfo.model.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dao.DayAirPollutionDAO;

public class GetDataFromAPI {

	public static  JSON getData(String url) {
		BufferedReader br = null;
		String result = "";
		JSONObject obj = null;
		JSONObject obj2 = null;
		JSONArray data = null;
		try {
//			url = "http://openAPI.seoul.go.kr:8088/797a42666568617038304266515253/json/DailyAverageAirQuality/1/30/20190625";
			URL urlstr = new URL(url);
			HttpURLConnection urlconnection = (HttpURLConnection) urlstr.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
				obj = JSONObject.fromObject(result);
//				obj2 = (JSONObject) obj.get("DailyAverageAirQuality");
//				data = (JSONArray) obj2.get("row");
//				for (int i =0 ; i < data.size() ; i++) {
//					JSONObject tempObj = (JSONObject) data.get(i);
//					String msrdt_de = (String) tempObj.get("MSRDT_DE");
//					String msrste_nm = (String) tempObj.get("MSRSTE_NM");
//					double no2 = (double) tempObj.get("NO2");
//					double o3 = (double) tempObj.get("O3");
//					double co = (double) tempObj.get("CO");
//					double so2 = (double) tempObj.get("SO2");
//					double pm10 = (double) tempObj.get("PM10");
//					double pm25 = (double) tempObj.get("PM25");
					
//					System.out.println(i+1+ " row selected");
//					System.out.println("-------------------------------------");
//					System.out.println("측정일시 : " + msrdt_de);
//					System.out.println("측정소명 : " + msrste_nm);
//					System.out.println("이산화질소농도(ppm) : " + no2);
//					System.out.println("오존농도(ppm) : " + o3);
//					System.out.println("일산화탄소농도(ppm) : " + co);
//					System.out.println("아황산가스(ppm) : " + so2);
//					System.out.println("미세먼지(㎍/㎥) : " + pm10);
//					System.out.println("초미세먼지(㎍/㎥) : " + pm25);
//					System.out.println("-------------------------------------");
//				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obj;
	}
public static void main(String[] args) throws SQLException {
	boolean result = DayAirPollutionDAO.addDayAirPollution(JSONPaser.jasonParse(null));
	
	System.out.println(JSONPaser.jasonParse(null));
	
}

}
