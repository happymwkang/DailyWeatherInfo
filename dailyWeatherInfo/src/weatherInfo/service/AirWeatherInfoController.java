package weatherInfo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.exception.NotExistException;
import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.model.dto.DayWeatherDTO;
import weatherInfo.model.dto.FineDustGradeDTO;
import weatherInfo.model.dto.ThiGradeDTO;
import weatherInfo.view.EndView;
import weatherInfo.view.SuccessView;

public class AirWeatherInfoController {
	private static AirWeatherInfoController instance = new AirWeatherInfoController();
	private AirWeatherInfoService service = AirWeatherInfoService.getInstance();
	
	// ---------------------- DayAirPollution CONTROLLER Section ----------------------
	
	public static AirWeatherInfoController getInstance() {
		return instance;
	}
	
	private AirWeatherInfoController() {};
	
	// ��� ������ ���� ���� ���
	public ArrayList<DayAirPollutionDTO> getAllDayAirPollution() {
		ArrayList<DayAirPollutionDTO> allDayAirPollution = null;
		try {
			allDayAirPollution = service.getAllDayAirPollutionData();
			SuccessView.selectSuccess("��� ���������� ���� ���");
			EndView.allAirPollutionListView(allDayAirPollution);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ���������� �˻��� ���� �߻�");
		}
		return allDayAirPollution;
	}

	// Ư�� ��¥, ���� ������ ���� ���
	public DayAirPollutionDTO getDayAirPollution(String date, String location) {
		DayAirPollutionDTO dayAirPollution = null;
		try {
			dayAirPollution = service.getOneDayAirPollutionData(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ ��������������");
			EndView.aDayAirPollutionView(dayAirPollution);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� �˻��� ���� ");
		}catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� ���� ");
		}
		return dayAirPollution;
	}
	
	// --------------------- DayWeather CONTROLLER Section ------------------------
	
	public ArrayList<DayWeatherDTO> getAllDayWeatherInfo() {
		ArrayList<DayWeatherDTO> allDayWeatherInfo = null;
		try {
			allDayWeatherInfo = service.getAllDayWeatherData();
			SuccessView.selectSuccess("��� ������� ���");
			EndView.allWeatherListView(allDayWeatherInfo);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� �������� �˻��� ���� �߻�");
		}
		return allDayWeatherInfo;
	}

	public DayWeatherDTO getDayWeatherInfo(String date, String location) {
		DayWeatherDTO dayWeatherInfo = null;
		try {
			dayWeatherInfo = service.getOneDayWeatherData(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ �������");
			EndView.aDayWeatherView(dayWeatherInfo);
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� �˻��� ���� ");
		} catch (NotExistException e) {
			e.printStackTrace();
			EndView.showError("���ڰ� ���ų� ������ �������� ����");
		}
		return dayWeatherInfo;
	}

	// ----------------------- Select Grade CONTROLLER Section ----------------------
	
	public FineDustGradeDTO getFineDustGrade(String date, String location) {
		FineDustGradeDTO result = null;
		try {
			result = service.getOneDayFineDustGrade(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ �̼����� ��� ���");
			EndView.aFineDustGradeView(result);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("�̼����� ������ ����");
		}catch (NotExistException s) {
			s.printStackTrace();
			EndView.showError("�̼����� ������ ����");
		}
		return result;
	}

	public ThiGradeDTO getThiGrade(String date, String stationName) {
		ThiGradeDTO result = null;
		try {
			result = service.getOneDayThiGrade(date, stationName);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + stationName + "������ �������� ��� ���");
			EndView.aThiGradeView(result);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}catch (NotExistException s) {
			s.printStackTrace();
			EndView.showError("�̼����� ������ ����");
		}
		return result;
	}
}
