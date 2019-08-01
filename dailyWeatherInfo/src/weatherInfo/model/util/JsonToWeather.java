package weatherInfo.model.util;

import java.util.ArrayList;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dto.DayWeatherDTO;

public class JsonToWeather {
	public static ArrayList<DayWeatherDTO> JSONToWeatherData(JSON json) throws Exception {
		ArrayList<DayWeatherDTO> weatherColumns= new ArrayList<DayWeatherDTO>();
		JSONObject obj = JSONObject.fromObject(json);
		JSONObject obj1 = (JSONObject) obj.get("DailyWeatherStation");
		JSONArray rowData = (JSONArray) obj1.get("row");
		
		for (int i = 0; i < rowData.size(); i++) {
			JSONObject dataObj = (JSONObject)rowData.get(i);
			weatherColumns.add(new DayWeatherDTO((String)dataObj.get("SAWS_OBS_TM"), (String)dataObj.get("STN_NM"),
					(double)dataObj.get("SAWS_TA_AVG"), (double)dataObj.get("SAWS_TA_MIN"), (double)dataObj.get("SAWS_TA_MAX"), 
					(double)dataObj.get("SAWS_HD_AVG"), (double)dataObj.get("SAWS_HD_MIN"), (double)dataObj.get("SAWS_HD_MAX"),
					(double)dataObj.get("SAWS_WS_AVG"), (double)dataObj.get("SAWS_WS_MAX"), (double)dataObj.get("SAWS_RN_SUM")));
		}
		return weatherColumns;
	}
}
