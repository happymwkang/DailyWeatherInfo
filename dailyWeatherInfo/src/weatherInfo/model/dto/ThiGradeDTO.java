package weatherInfo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThiGradeDTO {
	private String date; //SAWS_OBS_TM ��������
	private String stationName; //STN_NM ������
	private String thiGrade; //�������� ���
}
