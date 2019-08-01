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
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ���������� �˻��� ���� �߻�");
		}
		return allDayAirPollution;
	}

	// Ư�� ��¥, ���� ������ ���� ���
	public DayAirPollutionDTO getDayAirPollution(String date, String location) throws NotExistException {
		DayAirPollutionDTO dayAirPollution = null;
		try {
			dayAirPollution = service.getOneDayAirPollutionData(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ ��������������");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� �˻��� ���� ");
		}
		return dayAirPollution;
	}
	
	// --------------------- DayWeather CONTROLLER Section ------------------------
	
	public ArrayList<DayWeatherDTO> getAllDayWeatherInfo() {
		ArrayList<DayWeatherDTO> allDayWeatherInfo = null;
		try {
			allDayWeatherInfo = service.getAllDayWeatherData();
			SuccessView.selectSuccess("��� ������� ���");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� �������� �˻��� ���� �߻�");
		}
		return allDayWeatherInfo;
	}

	public DayAirPollutionDTO getDayWeatherInfo(String date, String location) throws NotExistException {
		DayAirPollutionDTO dayWeatherInfo = null;
		try {
			dayWeatherInfo = service.getOneDayAirPollutionData(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ �������");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� �˻��� ���� ");
		}
		return dayWeatherInfo;
	}

	// ----------------------- Select Grade CONTROLLER Section ----------------------
	
	public FineDustGradeDTO getFineDustGrade(String date, String location) {
		FineDustGradeDTO result = null;
		try {
			result = service.getOneDayFineDustGrade(date, location);
			SuccessView.selectSuccess("��¥�� "+ date + "�� " + location + "������ �̼����� ��� ���");
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
