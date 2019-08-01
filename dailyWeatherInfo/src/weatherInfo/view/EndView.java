package weatherInfo.view;

import java.util.ArrayList;

import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.model.dto.DayWeatherDTO;
import weatherInfo.model.dto.FineDustGradeDTO;
import weatherInfo.model.dto.ThiGradeDTO;

public class EndView {
	//----------------------- Show All About Weather Data ------------------- 
	
	public static void allWeatherListView(ArrayList<DayWeatherDTO> allDayWeatherInfo) {
		System.out.println("모든 기상정보 데이터 출력");
		int length = allDayWeatherInfo.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allDayWeatherInfo.get(index));
			}
		}
	}

	public static void aDayWeatherView(DayWeatherDTO DayWeatherInfo) {
		System.out.println(DayWeatherInfo);
	}
	
	//----------------------- Show All About Air Pollution Data ------------------- 
	
	public static void allAirPollutionListView(ArrayList<DayAirPollutionDTO> allDayAirPollutionInfo) {
		System.out.println("모든 기상정보 데이터 출력");
		int length = allDayAirPollutionInfo.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allDayAirPollutionInfo.get(index));
			}
		}
	}

	public static void aDayAirPollutionView(DayAirPollutionDTO DayAirPollutionInfo) {
		System.out.println(DayAirPollutionInfo);
	}
	
	//--------------------------- Show All About Grade -----------------------
	
	public static void aFineDustGradeView(FineDustGradeDTO dustGradeInfo) {
		System.out.println(dustGradeInfo);
	}
	
	public static void aThiGradeView(ThiGradeDTO thiGradeInfo) {
		System.out.println(thiGradeInfo);
	}
	
	//--------------------------- Show Exception Error -----------------------

	public static void showError(String message) {
		System.out.println(message);
	}
}
