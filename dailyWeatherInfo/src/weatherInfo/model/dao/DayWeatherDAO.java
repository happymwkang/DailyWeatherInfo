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
}
