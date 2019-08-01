package weatherInfo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.service.AirWeatherInfoService;
import weatherInfo.view.EndView;

public class AirWeatherInfoController {
	private static AirWeatherInfoService service = AirWeatherInfoService.getInstance();

	// 모든 대기오염 물질 정보 출력
	public static ArrayList<DayAirPollutionDTO> getAllDayAirPollution(){
			ArrayList<DayAirPollutionDTO> allDayAirPollution = null;
			try{
				allDayAirPollution = service.getAllDayAirPollutionData();		
				RunningSuccessView.selectSuccess();
			}catch(SQLException s){
				s.printStackTrace();
				EndView.showError("모든 대기오염정보 검색시 에러 발생");
			}
			return allDayAirPollution;
		}

	// 특정 날짜, 지역 대기오염 정보 출력
	public static DayAirPollutionDTO getDayAirPollution(String date, String location) {
		DayAirPollutionDTO dayAirPollution = null;
		try {
			dayAirPollution = service.getOneDayAirPollutionData(date, location);
			RunningSuccessView.selectSuccess();
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("대기오염정보를 해당 일, 지역으로 해당 대기오염정보 검색시 오류 ");
		}
		return dayAirPollution;
	}

	// 새로운 프로젝트 저장 로직
	public static boolean addProbonoProject(ProbonoProjectDTO probonoProject) {
		boolean result = false;
		try {
			result = ProbonoProjectDAO.addProbonoProject(probonoProject);
			RunningSuccessView.insertSuccess();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 저장시 에러 발생");
		}
		return result;
	}

	// 모든 프로젝트 검색 로직
	public static ArrayList<ActivistDTO> getAllActivists() {
		ArrayList<ActivistDTO> allProject = null;
		try {
			allProject = ActivistDAO.getAllActivists();
			RunningSuccessView.selectSuccess();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 재능 기부자 검색시 에러 발생");
		}
		return allProject;
	}

	// 프로보노 아이디로 프로보노 목적 수정
	public static boolean updateProbono(String probonoId, String probonoPurpose) {
		boolean result = false;
		try {
			result = ProbonoService.updateProbono(probonoId, probonoPurpose);
			RunningSuccessView.updateSuccess();
		} catch (Exception s) {
			s.printStackTrace();
			RunningEndView.showError("프로보노 id로 프로보노 목적 변경 오류");
		}
		return result;
	}

	// 프로보노 정보 검색
	public static ProbonoDTO getProbono(String probonoId) {
		ProbonoDTO probono = null;
		try {
			probono = ProbonoDAO.getProbono(probonoId);
			RunningSuccessView.selectSuccess();
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("프로보노 id로 해당 프로보노 검색 오류 ");
		}
		return probono;
	}
}
