/**
 * 
 */
package iAndroid.PingPong;

/**
 * @author Dagan
 * 
 */
public class Ball {

	private int x;
	private int y;

	private boolean movingRight;
	private boolean movingDown;
	private int maxWidth;
	private int maxHeight;
	
	public Ball(int startX, int startY, int width, int height) {
		this.x = startX;
		this.y = startY;
		
		movingRight = false;
		movingDown = false;

		maxHeight = height;
		maxWidth = width;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	public void moveBall() {
		if(movingRight)
			x++;
		else
			x--;
		
		if(x >= maxWidth)
			movingRight = false;
		if(x <= 1)
			movingRight = true;
		
		if(movingDown)
			y++;
		else
			y--;
		
		if(y >= maxHeight)
			movingDown = false;
		if(y <= 1)
			movingDown = true;
		
	}
}
