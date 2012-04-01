package iAndroid.PingPong;

/*
 * This class represents a paddle object which has some width and height and can move on the screen
 */
public class Paddle extends MovableObject
{

	private final int screenWidth; //the borders of paddles' movement
	public final int HEIGHT = 10; //paddles' height
	private final int WIDTH = 100; //paddles' width
	private float paddleDestination; //holds to where the paddle should be moved

	//receive the start position of the paddle and screen width
	public Paddle(int startX, int startY, int newScreenWidth)
	{
		x = startX;
		y = startY;
		screenWidth = newScreenWidth;
		paddleDestination = screenWidth / 2;
	}

	//return the width of the paddle
	public synchronized int getPaddleWidth()
	{
	return WIDTH;
	}

	//return the center of the paddle
	public synchronized int getMiddle()
	{
		return x + WIDTH/2;
	}

	//return the left border of the paddle
	@Override
	public synchronized int getLeft()
	{
		return x;
	}

	//return the right border of the paddle
	@Override
	public synchronized int getRight()
	{
		return x + WIDTH;
	}

	//return the top border of the paddle
	@Override
	public synchronized int getTop()
	{
		return y;
	 }

	//return the bottom border of the paddle
	@Override
	public synchronized int getBottom()
	{
		return y + HEIGHT;
	}

	//returns the  destination of the paddle,
	//synchronizing the access to the paddleDestination variable
	public synchronized float getPaddleDestination()
	{
		return paddleDestination;
	}

	//sets the new destination of the paddle, in response to user input,
	//synchronizing the access to the paddleDestination variable
	public synchronized void setPaddleDestination(float newDestination)
	{
		paddleDestination = newDestination;
	}

	//move the paddle to the right by single point
	public synchronized void moveRight()
	{
		//check if the movement exceeds screen limits:
		if (screenWidth > (getRight()+1))
			x++;
		else
			//place paddle at the rightmost corner
			x = screenWidth - WIDTH;
	}

	//move the paddle to the left by single point
	public synchronized void moveLeft()
	{
		//check if the movement exceeds screen limits:
		if ((getLeft()-1) > 0)
			x--;
		else
			//place paddle at the leftmost corner
			x = 0;
	}

	//move the paddle in the correct direction, determined by paddleDestination
	@Override
	public synchronized void move()
	{
		float destination;

		destination = getPaddleDestination();
		//is the destination is to the right of the paddle?
		if (getMiddle() < destination)
		{
			//move the paddle to the right
			moveRight();
		}
		//is the destination is to the left of the paddle?
		else if (getMiddle() > destination)
		{
			//move the paddle to the left
			moveLeft();
		}
	 }
}