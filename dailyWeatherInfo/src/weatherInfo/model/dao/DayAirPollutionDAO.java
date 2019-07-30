package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.model.util.DBUtil;

public class DayAirPollutionDAO {

	// ¿˙¿Â
	public static boolean addDayAirPollution(ArrayList<DayAirPollutionDTO> dayairpollution) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			for (int j = 0; j < dayairpollution.size(); j++) {
				DayAirPollutionDTO dailypollution = dayairpollution.get(j);
				pstmt = con.prepareStatement("insert into air_pollution values(?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, dailypollution.getMsrdt_de());
				pstmt.setString(2, dailypollution.getMsrste_nm());
				pstmt.setDouble(3, dailypollution.getNo2());
				pstmt.setDouble(4, dailypollution.getO3());
				pstmt.setDouble(5, dailypollution.getCo());
				pstmt.setDouble(6, dailypollution.getSo2());
				pstmt.setDouble(7, dailypollution.getPm10());
				pstmt.setDouble(8, dailypollution.getPm25());

				int result = pstmt.executeUpdate();
				if (result != 1) {
					return true;
				}
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}
