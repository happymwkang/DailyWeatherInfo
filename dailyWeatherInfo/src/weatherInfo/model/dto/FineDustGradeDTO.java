package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineDustGradeDTO {
	String grade;
	double pm10low;
	double pm10high;
	double pm25low;
	double pm25high;
}
