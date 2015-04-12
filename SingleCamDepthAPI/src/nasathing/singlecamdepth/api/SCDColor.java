package nasathing.singlecamdepth.api;

public class SCDColor {
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;
	
	public SCDColor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int red() {
		return red;
	}
	
	public int green() {
		return green;
	}
	
	public int blue() {
		return blue;
	}

}
