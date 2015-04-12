package nasathing.singlecamdepth.api;

import java.util.Iterator;

public class PixelCompareIterator implements Iterator<Double> {

	private SCDColor[][] matrix = null;
	
	private int curRowPos = 0;
	private int rows;
	
	private int curColPos = 0;
	private int cols;
	
	/**
	 * True: Horizontal
	 * False: Vertical
	 */
	boolean direction = true;
	
	public PixelCompareIterator(SCDColor[][] matrix) {
		this.matrix = matrix;
		
		this.curRowPos = 0;
		this.curColPos = 0;
		
		this.rows = matrix.length;
		
		this.direction = true;
		
		if (matrix.length >= 1)
			this.cols = matrix[0].length;
		
		// Make sure rows are same length, otherwise things could get messy.
		for (int i = 0; i < matrix.length; i++) {
			
			SCDColor[] cur = matrix[i];
			if (cur.length != cols) {
				SingleCamDepth.out.logWarning("Region's Rows are Not Same Length!");
				
				//Try to prevent first hasNext();
				rows = 0;
				cols = 0;
				
				return;
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		return this.curRowPos < rows && this.curColPos < cols;
	}

	@Override
	public Double next() {
		SCDColor cur = matrix[curRowPos][curColPos];
		SCDColor next = null;
		
		//If checking horizontally
		if (direction) {
			if (curColPos+1 < cols)
				next = matrix[curRowPos][curColPos+1];
			
			direction = false;
		} else { // check vertically
			if (curRowPos+1 < rows)
				next = matrix[curRowPos+1][curRowPos];
			
			direction = true;
			
			curColPos++;
			
			if (curColPos >= cols) {
				curRowPos++;
				curColPos = 0;
			}
		}
		
		if (next == null)
			return 0.0;
		
		int dRed = cur.red() - next.red();
		int dBlue = cur.blue() - next.blue();
		int dGreen = cur.green() - next.green();
		
		return Math.sqrt((dRed*dRed) + (dBlue*dBlue) + (dGreen*dGreen));
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
