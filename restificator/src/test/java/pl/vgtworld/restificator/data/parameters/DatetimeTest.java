package pl.vgtworld.restificator.data.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DatetimeTest {
	
	@Test
	public void shouldUseStandardToStringConvertionOnDateWhenNoPatternIsProvided() {
		Datetime datetime = new Datetime();
		Date date = new Date();
		datetime.setDate(date);
		
		String result = datetime.getParameterValue();
		
		assertThat(result).isEqualTo(date.toString());
	}
	
	@Test
	public void shouldApplyPositiveOffsetToDate() {
		Datetime datetime = new Datetime();
		Date currentDate = new Date();
		int offset = 3600;
		datetime.setDate(currentDate);
		datetime.setOffset(offset);
		
		String result = datetime.getParameterValue();
		
		assertThat(result).isEqualTo(new Date(currentDate.getTime() + offset).toString());
	}
	
	@Test
	public void shouldApplyNegativeOffsetToDate() {
		Datetime datetime = new Datetime();
		Date currentDate = new Date();
		int offset = -3600;
		datetime.setDate(currentDate);
		datetime.setOffset(offset);
		
		String result = datetime.getParameterValue();
		
		assertThat(result).isEqualTo(new Date(currentDate.getTime() + offset).toString());
	}
	
	@Test
	public void shouldUseProvidedDateFormatPattern() {
		Datetime datetime = new Datetime();
		Date currentDate = new Date();
		datetime.setDate(currentDate);
		String pattern = "yyyy-MM-dd HH:mm";
		datetime.setPattern(pattern);
		
		String result = datetime.getParameterValue();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
		assertThat(result).isEqualTo(dateFormatter.format(currentDate));
	}
	
}
