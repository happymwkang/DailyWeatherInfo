package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.LocationDTO;
import weatherInfo.model.util.DBUtil;

public class LocationDAO {
	
	public static ArrayList<LocationDTO> getAllLocation() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LocationDTO> allLocation = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from location");
			rset = pstmt.executeQuery();
			
			allLocation = new ArrayList<LocationDTO>();
			while(rset.next()){
				allLocation.add(new LocationDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return allLocation;
	}
	
	public static LocationDTO getOneLocation(String stationName, String msrste_nm) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		LocationDTO oneLocation = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from location where stn_nm = ? and msrste_nm = ?  ");
			pstmt.setString(1, stationName);
			pstmt.setString(2, msrste_nm);
			rset = pstmt.executeQuery();
			
			oneLocation = new LocationDTO();
			if (rset.next()) {
				oneLocation = (new LocationDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return oneLocation;
	}
}
