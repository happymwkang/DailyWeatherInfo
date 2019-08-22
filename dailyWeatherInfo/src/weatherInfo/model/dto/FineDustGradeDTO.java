package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineDustGradeDTO {
<<<<<<< HEAD
	private String msrdt_de;
	private String msrste_nm;
	private String grade;
	private String superGrade;
=======
	String grade;
	double pm10low;
	double pm10high;
	double pm25low;
	double pm25high;
>>>>>>> f6475985ab701cf1c32dd1a6c26599c5f1ec41d5
}
