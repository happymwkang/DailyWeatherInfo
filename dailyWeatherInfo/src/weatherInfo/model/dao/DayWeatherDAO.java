package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import weatherInfo.model.dto.DayWeatherDTO;
import weatherInfo.model.util.DBUtil;

public class DayWeatherDAO {
	public static boolean addDayWeatherData(ArrayList<DayWeatherDTO> dayWeather) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			for(int i=0; i<dayWeather.size(); i++) {
				pstmt = con.prepareStatement("insert into dayweatherinfo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, dayWeather.get(i).getDate());
				pstmt.setString(2, dayWeather.get(i).getStationName());
				pstmt.setDouble(3, dayWeather.get(i).getAvgTemperature());
				pstmt.setDouble(4, dayWeather.get(i).getMinTemperature());
				pstmt.setDouble(5, dayWeather.get(i).getMaxTemperature());
				pstmt.setDouble(6, dayWeather.get(i).getAvgHumid());
				pstmt.setDouble(7, dayWeather.get(i).getMinHumid());
				pstmt.setDouble(8, dayWeather.get(i).getMaxHumid());
				pstmt.setDouble(9, dayWeather.get(i).getAvgWindSpeed());
				pstmt.setDouble(10, dayWeather.get(i).getMaxWindSpeed());
				pstmt.setDouble(11, dayWeather.get(i).getSumRain());
			
				int result = pstmt.executeUpdate();
				
				if(result != 1){
					return true;
				}
			}
			
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static ArrayList<DayWeatherDTO> getAllDayWeather() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DayWeatherDTO> allDay = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dayWeatherInfo");
			rset = pstmt.executeQuery();
			
			allDay = new ArrayList<DayWeatherDTO>();
			while(rset.next()){
				allDay.add(new DayWeatherDTO(rset.getString(1), rset.getString(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8), rset.getDouble(9),
						rset.getDouble(10), rset.getDouble(11)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return allDay;
	}
	
	public static DayWeatherDTO getOneDayWeather(String date, String location) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DayWeatherDTO oneDay = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from dayWeatherInfo where saws_obs_tm = ? and stn_nm = ?");
			pstmt.setString(1, date);
			pstmt.setString(2, location);
			rset = pstmt.executeQuery();
			
			oneDay = new DayWeatherDTO();
			if (rset.next()) {
				oneDay = (new DayWeatherDTO(rset.getString(1), rset.getString(2), rset.getDouble(3), rset.getDouble(4),
						rset.getDouble(5), rset.getDouble(6), rset.getDouble(7), rset.getDouble(8), rset.getDouble(9),
						rset.getDouble(10), rset.getDouble(11)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return oneDay;
	}
	
	public static void main(String[] args) {

		DayWeatherDTO one = null;
		try {
			one = getOneDayWeather("20190728", "º≠√ ");
			
				System.out.println(one);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
