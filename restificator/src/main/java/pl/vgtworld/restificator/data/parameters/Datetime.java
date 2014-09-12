package pl.vgtworld.restificator.data.parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

public class Datetime extends Parameter {
	
	private Date date = new Date();
	
	private long offset = 0;
	
	private String pattern;
	
	@XmlTransient
	private SimpleDateFormat dateFormatter;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getOffset() {
		return offset;
	}
	
	public void setOffset(long offset) {
		this.offset = offset;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public String getParameterValue() {
		Date dateWithOffset = new Date(date.getTime() + offset);
		if (pattern == null) {
			return dateWithOffset.toString();
		}
		if (dateFormatter == null) {
			dateFormatter = new SimpleDateFormat(pattern);
		}
		return dateFormatter.format(dateWithOffset);
	}
	
	@Override
	public String toString() {
		return "Datetime [name=" + getName() + ", date=" + date + ", offset=" + offset + ", pattern=" + pattern + "]";
	}
	
}
