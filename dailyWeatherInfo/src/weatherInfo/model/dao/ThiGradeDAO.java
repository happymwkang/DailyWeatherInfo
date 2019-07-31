package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.ThiGradeDTO;
import weatherInfo.model.util.DBUtil;

public class ThiGradeDAO {
	public static ArrayList<ThiGradeDTO> getAllThiGrade() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ThiGradeDTO> allThiGrade = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from discomfort_grade");
			rset = pstmt.executeQuery();
			
			allThiGrade = new ArrayList<ThiGradeDTO>();
			while(rset.next()){
				allThiGrade.add(new ThiGradeDTO(rset.getString(1), rset.getDouble(2), rset.getDouble(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return allThiGrade;
	}
	
}
