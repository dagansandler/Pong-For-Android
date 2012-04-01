/**
 * 
 */
package iAndroid.PingPong;

/**
 * @author Dagan
 * 
 */
public class Ball extends MovableObject{

	private final int RESTART_X,RESTART_Y; //the location at which the game should be restarted
	public final int RADIUS = 10; //Ball radius from center

	private boolean movingRight;
	private boolean movingDown;
	private int maxWidth;
	private int maxHeight;
	
	private double deltaX;
	private double deltaY;
	
	public Ball(int startX, int startY, int width, int height) {
		this.RESTART_X = startX;
		this.RESTART_Y = startY;
		
		movingRight = false;
		movingDown = false;

		maxHeight = height;
		maxWidth = width;
		
		restart();
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return (int)x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return (int)y;
	}

	//Start a new game by placing the ball at the original position
	public void restart()
	{
		x = RESTART_X;
		y = RESTART_Y;
		movingDown = false;
		movingRight = false;
	}
	
	public void moveBall(int paddleBottomX, int paddleBottomY, int paddleTopX, int paddleTopY)
	   {
	      // Moving the ball
	      if (movingRight)
	         this.x+=deltaX;
	      else
	         this.x-=deltaX;

	      if (movingDown)
	         this.y+=deltaY;
	      else
	         this.y-=deltaY;

	      // Check if we need to change the ball direction horizontally
	      if (this.x >= this.maxWidth)
	         this.movingRight = false;

	      else if(this.x <= 1)
	         this.movingRight = true;

	      // Check if we have a collision on bottom
	      if ((this.y >= paddleBottomY-15) && ((this.x <= paddleBottomX+25) && (this.x >= paddleBottomX-25))){
	         this.movingDown = false;
	         deltaX+=(this.x - paddleBottomX)/25;
	         if (deltaX > 3.9)
	            deltaX = 3.9;
	         if (deltaX < 0.1)
	            deltaX = 0.1;
	         deltaY = Math.abs(Math.sqrt(4 - Math.pow(deltaX, 2)));
	         
	      }
	      // Check if we have a collision on top
	      if ((this.y <= paddleTopY+15) && ((this.x <= paddleTopX+25) && (this.x >= paddleTopX-25))){
	         this.movingDown = true;
	         deltaX+=(this.x - paddleTopX)/25;
	         if (deltaX > 3.9)
	            deltaX = 3.9;
	         if (deltaX < 0.1)
	            deltaX = 0.1;
	         deltaY = Math.abs(Math.sqrt(4 - Math.pow(deltaX, 2)));
	      }
	      
	   }
	
	public void move() {
		if(movingRight)
			x++;
		else
			x--;
		
		if(movingDown)
			y++;
		else
			y--;
		
		if(x >= maxWidth)
			movingRight = false;
		if(x <= 1)
			movingRight = true;
		
		if(y >= maxHeight)
			movingDown = false;
		if(y <= 1)
			movingDown = true;
		
	}

	@Override
	public int getLeft() {
		return x-this.RADIUS;
	}

	@Override
	public int getRight() {
		return x+this.RADIUS;
	}

	@Override
	public int getTop() {
		return y-RADIUS;
	}

	@Override
	public int getBottom() {
		return y+RADIUS;
	}

	public void bounce() {
		this.movingDown = !this.movingDown;
	}
}
