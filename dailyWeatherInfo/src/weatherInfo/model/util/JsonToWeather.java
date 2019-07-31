package weatherInfo.model.util;

import java.util.ArrayList;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import weatherInfo.model.dto.DayWeatherDTO;

public class JsonToWeather {
	public static ArrayList<DayWeatherDTO> JSONToWeather(JSON json) throws Exception {
//		JSONParser jsonparser = new JSONParser();
		ArrayList<DayWeatherDTO> weatherColumns= new ArrayList<DayWeatherDTO>();
//		JSONObject jsonobject = (JSONObject) jsonparser.parse(GetWeatherAPI.readUrl(GetWeatherAPI.urlConfig(1)));
		JSONObject obj = JSONObject.fromObject(json);
		JSONObject obj2 = (JSONObject) obj.get("DailyWeatherStation");
		JSONArray rowData = (JSONArray) obj2.get("row");
		JSONObject dataObj = null; 
		
		for (int i = 0; i < rowData.size(); i++) {
			 dataObj = (JSONObject)rowData.get(i);
			weatherColumns.add(new DayWeatherDTO((String)dataObj.get("SAWS_OBS_TM"), (String)dataObj.get("STN_NM"),
					(double)dataObj.get("SAWS_TA_AVG"), (double)dataObj.get("SAWS_TA_MIN"), (double)dataObj.get("SAWS_TA_MAX"), 
					(double)dataObj.get("SAWS_HD_AVG"), (double)dataObj.get("SAWS_HD_MIN"), (double)dataObj.get("SAWS_HD_MAX"),
					(double)dataObj.get("SAWS_WS_AVG"), (double)dataObj.get("SAWS_WS_MAX"), (double)dataObj.get("SAWS_RN_SUM")));
		}
		//System.out.println(columns);
		return weatherColumns;
	}
}
