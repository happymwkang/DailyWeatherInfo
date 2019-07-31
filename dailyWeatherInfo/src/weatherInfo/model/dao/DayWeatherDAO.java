package weatherInfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				DayWeatherDTO dailyWeather = dayWeather.get(i);
				pstmt = con.prepareStatement("insert into dayweatherinfo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, dailyWeather.getDate());
				pstmt.setString(2, dailyWeather.getStationName());
				pstmt.setDouble(3, dailyWeather.getAvgTemperature());
				pstmt.setDouble(4, dailyWeather.getMinTemperature());
				pstmt.setDouble(5, dailyWeather.getMaxTemperature());
				pstmt.setDouble(6, dailyWeather.getAvgHumid());
				pstmt.setDouble(7, dailyWeather.getMinHumid());
				pstmt.setDouble(8, dailyWeather.getMaxHumid());
				pstmt.setDouble(9, dailyWeather.getAvgWindSpeed());
				pstmt.setDouble(10, dailyWeather.getMaxWindSpeed());
				pstmt.setDouble(11, dailyWeather.getSumRain());
			
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
}
