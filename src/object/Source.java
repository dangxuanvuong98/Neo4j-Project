package object;

import java.util.Date;

public class Source {
	private String link;
	private Date date;

	public Source() {
		link = "";
		date = new Date();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}