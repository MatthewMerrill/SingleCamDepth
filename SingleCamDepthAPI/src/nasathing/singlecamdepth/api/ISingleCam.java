package nasathing.singlecamdepth.api;

public interface ISingleCam {
	
	public boolean prepare();
	
	public void setAperature(float value);
	public void setFocalLength(float value);
	
	public ImageFrame getOutput();

	public void logError(String string);
	
}
