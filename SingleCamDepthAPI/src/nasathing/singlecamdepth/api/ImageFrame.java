package nasathing.singlecamdepth.api;

public interface ImageFrame {
	
	public ISingleCam getCameraUsed();
	
	public double getRegionScore();
	
	public SCDColor[][] getMatrix();
	public ImageRegion getRegion(int row, int column);
	
	public int getRegionColumns();
	public int getRegionRows();

}
