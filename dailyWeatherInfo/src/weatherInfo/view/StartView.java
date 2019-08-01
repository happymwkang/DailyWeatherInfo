package weatherInfo.view;

import weatherInfo.service.AirWeatherInfoController;
import weatherInfo.service.AirWeatherInfoService;

public class StartView {
	public static AirWeatherInfoController service = AirWeatherInfoController.getInstance();
	
	public static void main(String [] args){
		
		System.out.println("***** 모든 Project 검색 *****");
	
		service.getAllDayAirPollution();
					
//		
//		//모든 재능 기부자들 검색
//		System.out.println("\n***** 모든 재능 기부자 검색 *****");
//		RunningEndView.projectListView(ProbonoProjectController.getAllActivists());
//		
//		//특정 프로보노 정보 검색
//		System.out.println("\n***** 특정 프로보노 정보 검색 *****");
//		RunningEndView.allView(ProbonoProjectController.getProbono("schweitzer"));
	}
		
}
