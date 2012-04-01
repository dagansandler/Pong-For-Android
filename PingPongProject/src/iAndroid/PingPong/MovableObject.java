package iAndroid.PingPong;

/*
 * This base class defines an abstract object which has central location (x,y),
 * some dimensions which can be determined by calling the methods
 * getLeft(), getRight(), getTop(),getBottom()
 */
public abstract class MovableObject
{
	protected int x; //current horizontal position of the center of the object
	protected int y; //current vertical position of the center of the object

	// Return the center horizontal position of the object
	public int getX()
	{
		return x;
	}

	// Return the center vertical position of the object
	public int getY()
	{
		return y;
	}

	//should return the left border of the object
	public abstract int getLeft();

	//should return the right border of the object
	public abstract int getRight();

	//should return the top border of the object
	public abstract int getTop();

	//should return the bottom border of the object
	public abstract int getBottom();

	//This method should move the object
	public abstract void move();
}