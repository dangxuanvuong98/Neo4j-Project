package object;

import java.util.Date;

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
}
