package weatherInfo.view;

import java.util.ArrayList;

import weatherInfo.model.dto.DayWeatherDTO;

public class EndView {
	// ��� ������� ���
	public static void allWeatherListView(ArrayList<DayWeatherDTO> allDayWeatherInfo) {
		System.out.println("��� ������� ������ ���");
		int length = allDayWeatherInfo.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("�˻����� " + (index + 1) + " - " + allDayWeatherInfo.get(index));
			}
		}
	}

	// Ư�� ������Ʈ ���
	public static void aDayWeatherView(DayWeatherDTO DayWeatherInfo) {
		System.out.println(DayWeatherInfo);
	}

	// ?? ��� DTO ���� ����ϴ� �޼ҵ�
	//public static void allView(Object object) {
		//System.out.println(object);
	//}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}
}
