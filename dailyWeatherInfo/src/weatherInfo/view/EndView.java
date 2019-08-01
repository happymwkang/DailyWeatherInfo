package weatherInfo.view;

import java.util.ArrayList;

import weatherInfo.model.dto.DayWeatherDTO;

public class EndView {
	// 모든 기상정보 출력
	public static void allWeatherListView(ArrayList<DayWeatherDTO> allDayWeatherInfo) {
		System.out.println("모든 기상정보 데이터 출력");
		int length = allDayWeatherInfo.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("검색정보 " + (index + 1) + " - " + allDayWeatherInfo.get(index));
			}
		}
	}

	// 특정 프로젝트 출력
	public static void aDayWeatherView(DayWeatherDTO DayWeatherInfo) {
		System.out.println(DayWeatherInfo);
	}

	// ?? 모든 DTO 정보 출력하는 메소드
	//public static void allView(Object object) {
		//System.out.println(object);
	//}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}
}
