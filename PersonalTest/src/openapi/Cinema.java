package openapi;

public class Cinema {
	
	String title, mapX,  mapY,  address,  link;
	
	
	public Cinema(String title, String mapX, String mapY, String address, String link) {
		this.title=title;
		this.mapX = mapX;
		this.mapY = mapY;
		this.address = address;
		this.link =link;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMapX() {
		return mapX;
	}


	public void setMapX(String mapX) {
		this.mapX = mapX;
	}


	public String getMapY() {
		return mapY;
	}


	public void setMapY(String mapY) {
		this.mapY = mapY;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}

	
}
