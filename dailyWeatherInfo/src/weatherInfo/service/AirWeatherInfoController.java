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
	
	// 모든 대기오염 물질 정보 출력
	public ArrayList<DayAirPollutionDTO> getAllDayAirPollution() {
		ArrayList<DayAirPollutionDTO> allDayAirPollution = null;
		try {
			allDayAirPollution = service.getAllDayAirPollutionData();
			SuccessView.selectSuccess("모든 대기오염물질 정보 출력");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 대기오염정보 검색시 에러 발생");
		}
		return allDayAirPollution;
	}

	// 특정 날짜, 지역 대기오염 정보 출력
	public DayAirPollutionDTO getDayAirPollution(String date, String location) throws NotExistException {
		DayAirPollutionDTO dayAirPollution = null;
		try {
			dayAirPollution = service.getOneDayAirPollutionData(date, location);
			SuccessView.selectSuccess("날짜인 "+ date + "과 " + location + "지역의 대기오염물질정보");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("대기오염정보를 해당 일, 지역으로 해당 대기오염정보 검색시 오류 ");
		}
		return dayAirPollution;
	}
	
	// --------------------- DayWeather CONTROLLER Section ------------------------
	
	public ArrayList<DayWeatherDTO> getAllDayWeatherInfo() {
		ArrayList<DayWeatherDTO> allDayWeatherInfo = null;
		try {
			allDayWeatherInfo = service.getAllDayWeatherData();
			SuccessView.selectSuccess("모든 기상정보 출력");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 날씨정보 검색시 에러 발생");
		}
		return allDayWeatherInfo;
	}

	public DayAirPollutionDTO getDayWeatherInfo(String date, String location) throws NotExistException {
		DayAirPollutionDTO dayWeatherInfo = null;
		try {
			dayWeatherInfo = service.getOneDayAirPollutionData(date, location);
			SuccessView.selectSuccess("날짜인 "+ date + "과 " + location + "지역의 기상정보");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("대기오염정보를 해당 일, 지역으로 해당 대기오염정보 검색시 오류 ");
		}
		return dayWeatherInfo;
	}

	// ----------------------- Select Grade CONTROLLER Section ----------------------
	
	public FineDustGradeDTO getFineDustGrade(String date, String location) {
		FineDustGradeDTO result = null;
		try {
			result = service.getOneDayFineDustGrade(date, location);
			SuccessView.selectSuccess("날짜인 "+ date + "과 " + location + "지역의 미세먼지 등급 출력");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("미세먼지 보려다 실패");
		}catch (NotExistException s) {
			s.printStackTrace();
			EndView.showError("미세먼지 보려다 없네");
		}
		return result;
	}

	public ThiGradeDTO getThiGrade(String date, String stationName) {
		ThiGradeDTO result = null;
		try {
			result = service.getOneDayThiGrade(date, stationName);
			SuccessView.selectSuccess("날짜인 "+ date + "과 " + stationName + "지역의 불쾌지수 등급 출력");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 재능 기부자 검색시 에러 발생");
		}catch (NotExistException s) {
			s.printStackTrace();
			EndView.showError("미세먼지 보려다 없네");
		}
		return result;
	}
}
