package object;

import java.util.Date;

/**
 * Lớp lưu trữ thông tin của thực thể Event
 * 
 */
public class Event extends Entity {
	private Date timeStart;
	private Date timeEnd;
	private String venue;

	public Event() {
		super();
		this.timeStart = new Date();
		this.timeEnd = new Date();
		this.venue = new String();
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String setVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "###Name:" + name + "\n-ID:" + id + "\n-Description:"
				+ description + "\n-Source:" + source + "\n-Start:" + timeStart
				+ "\n-End:" + timeEnd + "\n-At:" + venue;
	}
}
