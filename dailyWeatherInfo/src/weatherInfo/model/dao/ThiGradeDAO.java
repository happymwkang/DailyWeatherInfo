package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import weatherInfo.model.dto.ThiGradeDTO;
import weatherInfo.model.util.DBUtil;


public class ThiGradeDAO {
	
	public static ThiGradeDTO getThiGrade(String date , String stationName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ThiGradeDTO dayThiGrade = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select a.saws_obs_tm, a.stn_nm, c.grade from dayweatherinfo a,(\r\n" + 
										"select saws_obs_tm, stn_nm, 9/5*saws_ta_avg -0.55*(1-saws_hd_avg*0.01)*(9/5*saws_ta_avg-26)+32 discomfort \r\n" + 
										"from dayweatherinfo) b, discomfort_grade c\r\n" + 
										"where a.saws_obs_tm = b.saws_obs_tm \r\n" + 
										"and a.stn_nm = b.stn_nm \r\n" + 
										"and b.discomfort between c.low and c.high \r\n" +
										"and a.saws_obs_tm = ? and a.stn_nm = ?");
			pstmt.setString(1, date);
			pstmt.setString(2, stationName);
			rset = pstmt.executeQuery();
			
			dayThiGrade = new ThiGradeDTO();
			while(rset.next()){
				dayThiGrade = (new ThiGradeDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return dayThiGrade;
	}
	
}
