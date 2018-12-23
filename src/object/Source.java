package object;

import java.util.Date;

/**
 * Lá»›p lÆ°u trá»¯ thÃ´ng tin vá»� nguá»“n gá»‘c trÃ­ch rÃºt cá»§a thá»±c thá»ƒ
 * 
 */
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

	@Override
	public String toString() {
		return "link:" + link + ",extracted at " + date;
	}

}