package weatherInfo.model.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dao.DayAirPollutionDAO;

public class GetAirPollutionAPI {

	public static JSON getData(String dateConfig) {
		BufferedReader br = null;
		String result = "";
		JSONObject obj = null;
		JSONObject obj2 = null;
		JSONArray data = null;
		String url = null;
		try {
			url = "http://openAPI.seoul.go.kr:8088/797a42666568617038304266515253/json/DailyAverageAirQuality/1/999/"+dateConfig;
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
//					System.out.println("�����Ͻ� : " + msrdt_de);
//					System.out.println("�����Ҹ� : " + msrste_nm);
//					System.out.println("�̻�ȭ���ҳ�(ppm) : " + no2);
//					System.out.println("������(ppm) : " + o3);
//					System.out.println("�ϻ�ȭź�ҳ�(ppm) : " + co);
//					System.out.println("��Ȳ�갡��(ppm) : " + so2);
//					System.out.println("�̼�����(��/��) : " + pm10);
//					System.out.println("�ʹ̼�����(��/��) : " + pm25);
//					System.out.println("-------------------------------------");
//				}
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
            cal.add(Calendar.DATE, i);		//��¥ ���ϱ�
//            cal.add(Calendar.MONTH, 1);		//�� ���ϱ�

//            String varDate = new SimpleDateFormat("yyyyMMdd").format(date);
//	System.out.println("��¥ Ȯ��"+format.format(cal.getTime()));
	return format.format(cal.getTime());
	}


	
public static void main(String[] args) throws SQLException, ParseException {
	for (int i = 0 ; i < 90 ; i ++) {
	 DayAirPollutionDAO.addDayAirPollution(JsonToAirPollution.jasonParse(getData(urlConfig(i))));
	}
//	System.out.println(JSONPaser.jasonParse(null));
//	System.out.println(urlConfig(50));
}

}
