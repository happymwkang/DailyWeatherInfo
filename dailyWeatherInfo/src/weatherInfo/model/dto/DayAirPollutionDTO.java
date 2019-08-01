package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayAirPollutionDTO {
	/*
순번	출력명		출력설명
1 	MSRDT_DE 	측정일시 
2 	MSRSTE_NM 	측정소명 
3 	NO2 		이산화질소농도(ppm) 
4 	O3 			오존농도(ppm) 
5 	CO 			일산화탄소농도(ppm) 
6 	SO2 		아황산가스(ppm) 
7 	PM10 		미세먼지(㎍/㎥) 
8 	PM25 		초미세먼지(㎍/㎥) 
	 */
	private String msrdt_de;
	private String msrste_nm;
	private double no2;
	private double o3;
	private double co;
	private double so2;
	private double pm10;
	private double pm25;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 측정일시 : ");
		builder.append(msrdt_de + "\n");
		builder.append("2. 측정소명 : ");
		builder.append(msrste_nm + "\n");
		builder.append("3. 이산화질소농도(ppm) : ");
		builder.append(no2 + "\n");
		builder.append("4. 오존농도(ppm) : ");
		builder.append(o3 + "\n");
		builder.append("5. 일산화탄소농도(ppm) : ");
		builder.append(co + "\n");
		builder.append("6. 아황산가스(ppm) : ");
		builder.append(so2 + "\n");
		builder.append("7. 미세먼지(㎍/㎥) : ");
		builder.append(pm10 + "\n");
		builder.append("8. 초미세먼지(㎍/㎥): ");
		builder.append(pm25 + "\n");
		return builder.toString();
	}
	
}
