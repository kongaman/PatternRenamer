package application;

public class NamePart {
	
	private String namePart;
	private boolean visibile;
	
	public NamePart(String namePart, boolean visibile) {
		this.namePart = namePart;
		this.visibile = visibile;
	}

	public String getNamePart() {
		return namePart;
	}

	public void setNamePart(String namePart) {
		this.namePart = namePart;
	}

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	
	

}
