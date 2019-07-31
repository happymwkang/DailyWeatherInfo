package weatherInfo.model.dto;

import lombok.Data;

@Data
public class DayAirPollutionDTO {
	/*
����	��¸�		��¼���
1 	MSRDT_DE 	�����Ͻ� 
2 	MSRSTE_NM 	�����Ҹ� 
3 	NO2 		�̻�ȭ���ҳ�(ppm) 
4 	O3 			������(ppm) 
5 	CO 			�ϻ�ȭź�ҳ�(ppm) 
6 	SO2 		��Ȳ�갡��(ppm) 
7 	PM10 		�̼�����(��/��) 
8 	PM25 		�ʹ̼�����(��/��) 
	 */
	private String msrdt_de;
	private String msrste_nm;
	private double no2;
	private double o3;
	private double co;
	private double so2;
	private double pm10;
	private double pm25;
	
	public DayAirPollutionDTO(String msrdt_de, String msrste_nm, double no2, double o3, double co, double so2, double pm10, double pm25) {
		super();
		this.msrdt_de = msrdt_de;
		this.msrste_nm = msrste_nm;
		this.no2 = no2;
		this.o3 = o3;
		this.co = co;
		this.so2 = so2;
		this.pm10 = pm10;
		this.pm25 = pm25;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. �����Ͻ� : ");
		builder.append(msrdt_de);
		builder.append("2. �����Ҹ� : ");
		builder.append(msrste_nm);
		builder.append("3. �̻�ȭ���ҳ�(ppm) : ");
		builder.append(no2);
		builder.append("4. ������(ppm) : ");
		builder.append(o3);
		builder.append("5. �ϻ�ȭź�ҳ�(ppm) : ");
		builder.append(co);
		builder.append("6. ��Ȳ�갡��(ppm) : ");
		builder.append(so2);
		builder.append("7. �̼�����(��/��) : ");
		builder.append(pm10);
		builder.append("8. �ʹ̼�����(��/��): ");
		builder.append(pm25);
		return builder.toString();
	}
	
}
