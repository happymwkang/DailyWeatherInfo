package weatherInfo.model.util;

import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import weatherInfo.model.dto.DayWeatherDTO;

public class JsonToWeather {
	public static ArrayList<DayWeatherDTO> JSONToWeather() throws Exception {
		JSONParser jsonparser = new JSONParser();
		ArrayList<DayWeatherDTO> weatherColumns= new ArrayList<DayWeatherDTO>();
		JSONObject jsonobject = (JSONObject) jsonparser.parse(GetWeatherAPI.readUrl(GetWeatherAPI.urlConfig(1)));
		JSONObject json = (JSONObject) jsonobject.get("DailyWeatherStation");
		JSONArray rowData = (JSONArray) json.get("row");
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
