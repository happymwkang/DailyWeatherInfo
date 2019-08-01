package weatherInfo.service;

import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.service.AirWeatherInfoService;
import weatherInfo.view.EndView;

public class AirWeatherInfoController {
	private static AirWeatherInfoService service = AirWeatherInfoService.getInstance();

	// ��� ������ ���� ���� ���
	public static ArrayList<DayAirPollutionDTO> getAllDayAirPollution(){
			ArrayList<DayAirPollutionDTO> allDayAirPollution = null;
			try{
				allDayAirPollution = service.getAllDayAirPollutionData();		
				RunningSuccessView.selectSuccess();
			}catch(SQLException s){
				s.printStackTrace();
				EndView.showError("��� ���������� �˻��� ���� �߻�");
			}
			return allDayAirPollution;
		}

	// Ư�� ��¥, ���� ������ ���� ���
	public static DayAirPollutionDTO getDayAirPollution(String date, String location) {
		DayAirPollutionDTO dayAirPollution = null;
		try {
			dayAirPollution = service.getOneDayAirPollutionData(date, location);
			RunningSuccessView.selectSuccess();
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("������������ �ش� ��, �������� �ش� ���������� �˻��� ���� ");
		}
		return dayAirPollution;
	}

	// ���ο� ������Ʈ ���� ����
	public static boolean addProbonoProject(ProbonoProjectDTO probonoProject) {
		boolean result = false;
		try {
			result = ProbonoProjectDAO.addProbonoProject(probonoProject);
			RunningSuccessView.insertSuccess();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ ����� ���� �߻�");
		}
		return result;
	}

	// ��� ������Ʈ �˻� ����
	public static ArrayList<ActivistDTO> getAllActivists() {
		ArrayList<ActivistDTO> allProject = null;
		try {
			allProject = ActivistDAO.getAllActivists();
			RunningSuccessView.selectSuccess();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}
		return allProject;
	}

	// ���κ��� ���̵�� ���κ��� ���� ����
	public static boolean updateProbono(String probonoId, String probonoPurpose) {
		boolean result = false;
		try {
			result = ProbonoService.updateProbono(probonoId, probonoPurpose);
			RunningSuccessView.updateSuccess();
		} catch (Exception s) {
			s.printStackTrace();
			RunningEndView.showError("���κ��� id�� ���κ��� ���� ���� ����");
		}
		return result;
	}

	// ���κ��� ���� �˻�
	public static ProbonoDTO getProbono(String probonoId) {
		ProbonoDTO probono = null;
		try {
			probono = ProbonoDAO.getProbono(probonoId);
			RunningSuccessView.selectSuccess();
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���κ��� id�� �ش� ���κ��� �˻� ���� ");
		}
		return probono;
	}
}
