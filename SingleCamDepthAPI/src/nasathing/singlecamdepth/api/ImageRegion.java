package nasathing.singlecamdepth.api;

public class ImageRegion {
	
	private SCDColor[][] matrix = null;
	private ISingleCam cameraUsed;
	
	public ImageRegion(SCDColor[][] matrix, ISingleCam cameraUsed) {
		this.matrix = matrix;
		this.cameraUsed = cameraUsed;
	}
	
	public double getPixelVariance() {
		double variance = 0;
		
		PixelCompareIterator itr = new PixelCompareIterator(matrix);
		while (itr.hasNext()) {
			variance += itr.next().doubleValue();
		}
		
		return variance;
	}
	
	public SCDColor[][] getMatrix() {
		return matrix;
	}

}
