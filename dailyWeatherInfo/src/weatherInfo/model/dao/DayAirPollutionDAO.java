package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.DayAirPollutionDTO;
import weatherInfo.model.util.DBUtil;

public class DayAirPollutionDAO {

	// 저장
	public static boolean addDayAirPollution(ArrayList<DayAirPollutionDTO> dayairpollution) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			for (int j = 0; j < dayairpollution.size(); j++) {
				DayAirPollutionDTO dailypollution = dayairpollution.get(j);
				pstmt = con.prepareStatement("insert into dayairpollution values(?, ?, ?, ?, ?, ?, ?, ?)");
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
	
	public static ArrayList<DayAirPollutionDTO> getAllDayAirPollution() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DayAirPollutionDTO> allDay = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dayAirPollution");
			rset = pstmt.executeQuery();
			
			allDay = new ArrayList<DayAirPollutionDTO>();
			while(rset.next()){
				allDay.add(new DayAirPollutionDTO(rset.getString(1), rset.getString(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return allDay;
	}
	
	public static DayAirPollutionDTO getOneDayAirPollution(String date, String location) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DayAirPollutionDTO oneDay = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dayAirPollution where msrdt_de = ? and msrste_nm = ?");
			pstmt.setString(1, date);
			pstmt.setString(2, location);
			rset = pstmt.executeQuery();
			
			oneDay = new DayAirPollutionDTO();
			if (rset.next()) {
				oneDay = (new DayAirPollutionDTO(rset.getString(1), rset.getString(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return oneDay;
	}
	
	/*       Test
	public static void main(String[] args) {

		DayAirPollutionDTO one = null;
		try {
			one = getOneDayAirPollution("20190728", "서초구");
			
				System.out.println(one);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 */
}
