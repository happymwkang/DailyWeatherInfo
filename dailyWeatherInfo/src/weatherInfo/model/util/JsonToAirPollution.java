package weatherInfo.model.util;

import java.util.ArrayList;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dto.DayAirPollutionDTO;

public class JsonToAirPollution {

	public static ArrayList<DayAirPollutionDTO> JSONToAirPollutionData(JSON json) {
		
		ArrayList<DayAirPollutionDTO> dayairpollution = new ArrayList<DayAirPollutionDTO>();
		JSONObject obj = JSONObject.fromObject(json);
		JSONObject obj2 = (JSONObject) obj.get("DailyAverageAirQuality");
		JSONArray data = (JSONArray) obj2.get("row");
		for (int i =0 ; i < data.size() ; i++) {
			JSONObject dataObj = (JSONObject) data.get(i);
			dayairpollution.add(new DayAirPollutionDTO((String) dataObj.get("MSRDT_DE"), (String) dataObj.get("MSRSTE_NM"),
					(double) dataObj.get("NO2"),(double) dataObj.get("O3"), (double) dataObj.get("CO"), 
					(double) dataObj.get("SO2"),(double) dataObj.get("PM10"),(double) dataObj.get("PM25")) );

		}
		return dayairpollution;
	}
	

}
