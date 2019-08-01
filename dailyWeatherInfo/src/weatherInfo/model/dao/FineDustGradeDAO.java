package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import weatherInfo.model.dto.FineDustGradeDTO;
import weatherInfo.model.util.DBUtil;

public class FineDustGradeDAO {
	public static FineDustGradeDTO getFineDustGrade(String date, String location) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FineDustGradeDTO finedustgrade = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select a.msrdt_de, a.msrste_nm, grade, supergrade from \r\n" + 
										"(select msrdt_de, MSRSTE_NM,grade grade from dayairPollution a, finedust_grade b \r\n" + 
										"where a.pm10 between pm10_low and pm10_high) a, " + 
										"(select msrdt_de, MSRSTE_NM,grade supergrade from dayairPollution a, finedust_grade b \r\n" + 
										"where a.pm10 between pm25_low and pm25_high) b \r\n" + 
										 "where a.msrdt_de = b.msrdt_de and a.msrste_nm = b.msrste_nm \r\n" + 
										 "and a.msrdt_de = ? and a.msrste_nm = ?");
			pstmt.setString(1, date);
			pstmt.setString(2, location);
			rset = pstmt.executeQuery();
			
			finedustgrade = new FineDustGradeDTO();
			if (rset.next()) {
				finedustgrade = (new FineDustGradeDTO(rset.getString(1), rset.getString(2), rset.getString(3),rset.getString(4)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return finedustgrade;
	}
}
