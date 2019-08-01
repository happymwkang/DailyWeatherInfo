package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineDustGradeDTO {
	private String msrdt_de;
	private String msrste_nm;
	private String grade;
	private String superGrade;
}
