package weatherInfo.view;

import weatherInfo.service.AirWeatherInfoController;
import weatherInfo.service.AirWeatherInfoService;

public class StartView {
	public static AirWeatherInfoController service = AirWeatherInfoController.getInstance();
	
	public static void main(String [] args){
		
		System.out.println("***** ��� Project �˻� *****");
	
		service.getAllDayAirPollution();
					
//		
//		//��� ��� ����ڵ� �˻�
//		System.out.println("\n***** ��� ��� ����� �˻� *****");
//		RunningEndView.projectListView(ProbonoProjectController.getAllActivists());
//		
//		//Ư�� ���κ��� ���� �˻�
//		System.out.println("\n***** Ư�� ���κ��� ���� �˻� *****");
//		RunningEndView.allView(ProbonoProjectController.getProbono("schweitzer"));
	}
		
}
