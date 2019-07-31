package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayWeatherDTO {
	private String date; //SAWS_OBS_TM 관측일자
	private String stationName; //STN_NM 지점명
	private double avgTemperature; //SAWS_TA_AVG  
	private double minTemperature; //SAWS_TA_MIN
	private double maxTemperature; //SAWS_TA_MAX
	private double avgHumid; //SAWS_HD_AVG
	private double minHumid; //SAWS_HD_MIN
	private double maxHumid; //SAWS_HD_MAX
	private double avgWindSpeed; //SAWS_WS_AVG
	private double maxWindSpeed; //SAWS_WS_MAX
	private double sumRain; //SAWS_RN_SUM 강수량
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append(super.toString());
		builder.append("\n관측일자 : ");
		builder.append(date + "\n");
		builder.append("지점명 : ");
		builder.append(stationName + "\n");
		builder.append("평균기온 : ");
		builder.append(avgTemperature + "\n");
		builder.append("최저기온 : ");
		builder.append(minTemperature + "\n");
		builder.append("최대기온 : ");
		builder.append(maxTemperature + "\n");
		builder.append("평균습도 : ");
		builder.append(avgHumid + "\n");
		builder.append("최저습도 : ");
		builder.append(minHumid + "\n");
		builder.append("최고습도 : ");
		builder.append(maxHumid + "\n");	
		builder.append("평균풍속 : ");
		builder.append(avgWindSpeed + "\n");
		builder.append("최대풍속 : ");
		builder.append(maxWindSpeed + "\n");
		builder.append("강수량 : ");
		builder.append(sumRain + "\n");
		return builder.toString();
		
	}
}
