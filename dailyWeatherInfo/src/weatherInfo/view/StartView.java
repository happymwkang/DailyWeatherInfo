package weatherInfo.view;

import weatherInfo.service.AirWeatherInfoController;

public class StartView {
	public static AirWeatherInfoController controller = AirWeatherInfoController.getInstance();
	
	public static void main(String [] args) {
		
		// -------------------------- Start weather service ----------------------
//		System.out.println("***** 모든 기상정보  조회 *****");
//		controller.getAllDayWeatherInfo();
					
		System.out.println("***** 일자별 기상정보  조회 *****");
		controller.getDayWeatherInfo("20190501", "서초");

		// -------------------------- Start air pollution service ----------------------
//		System.out.println("***** 모든 대기오염물질 정보 조회 *****");
//		controller.getAllDayAirPollution();
		
		System.out.println("***** 일자별 대기오염물질 정보  조회 *****");
		controller.getDayAirPollution("20190710", "서초구");
		
		// -------------------------- Start grade service ----------------------
		System.out.println("***** 일자별 & 지역별 미세먼지 등급 조회 *****");
		controller.getFineDustGrade("20190601", "영등포구");
		
		System.out.println("***** 일자별 & 지역별 불쾌지수 등급 조회 *****");
		controller.getThiGrade("20190501", "마포");
	}
		
}
