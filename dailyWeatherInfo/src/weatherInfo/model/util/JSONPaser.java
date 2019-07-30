package weatherInfo.model.util;

import java.util.ArrayList;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dto.DayAirPollutionDTO;

public class JSONPaser {

	public static ArrayList<DayAirPollutionDTO> jasonParse(JSON json) {
		
		
		String url = "http://openAPI.seoul.go.kr:8088/797a42666568617038304266515253/json/DailyAverageAirQuality/1/30/";
		JSONObject obj = JSONObject.fromObject(GetDataFromAPI.getData(url +"20190625"));
		ArrayList<DayAirPollutionDTO> dayairpollution = new ArrayList<DayAirPollutionDTO>();
		JSONObject obj2 = (JSONObject) obj.get("DailyAverageAirQuality");
		JSONArray data = (JSONArray) obj2.get("row");
		for (int i =0 ; i < data.size() ; i++) {
			JSONObject dataObj = (JSONObject) data.get(i);
			dayairpollution.add(new DayAirPollutionDTO((String) dataObj.get("MSRDT_DE"), (String) dataObj.get("MSRSTE_NM"),
					(double) dataObj.get("NO2"),(double) dataObj.get("O3"), (double) dataObj.get("CO"), 
					(double) dataObj.get("SO2"),(double) dataObj.get("PM10"),(double) dataObj.get("PM25")) );
//			String msrdt_de = (String) tempObj.get("MSRDT_DE");
//			String msrste_nm = (String) tempObj.get("MSRSTE_NM");
//			double no2 = (double) tempObj.get("NO2");
//			double o3 = (double) tempObj.get("O3");
//			double co = (double) tempObj.get("CO");
//			double so2 = (double) tempObj.get("SO2");
//			double pm10 = (double) tempObj.get("PM10");
//			double pm25 = (double) tempObj.get("PM25");
			
//			System.out.println(i+1+ " row selected");
//			System.out.println("-------------------------------------");
//			System.out.println("�����Ͻ� : " + msrdt_de);
//			System.out.println("�����Ҹ� : " + msrste_nm);
//			System.out.println("�̻�ȭ���ҳ�(ppm) : " + no2);
//			System.out.println("������(ppm) : " + o3);
//			System.out.println("�ϻ�ȭź�ҳ�(ppm) : " + co);
//			System.out.println("��Ȳ�갡��(ppm) : " + so2);
//			System.out.println("�̼�����(��/��) : " + pm10);
//			System.out.println("�ʹ̼�����(��/��) : " + pm25);
//			System.out.println("-------------------------------------");

		}
		return dayairpollution;
	}
}
