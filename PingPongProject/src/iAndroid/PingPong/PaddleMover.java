package iAndroid.PingPong;

/*
 * PaddleMover is responsible for moving the paddle in response to user input,
 * in a separate thread
 */
public class PaddleMover extends Thread
{
	private Paddle gamePaddle; //holds a reference to the paddle
	private PingPongView gameView; //holds a reference to the main view

	//initialize class variables
	public PaddleMover(Paddle thePaddle, PingPongView mainView)
	{
		gamePaddle = thePaddle;
		gameView = mainView;
	}

	//main method of the current thread
	@Override
	public void run()
	{
		//infinitely loop, and move the paddle if necessary
		while (1 < 2)
		{
			//check whether the paddle should be moved
			if (gamePaddle.getMiddle() != gamePaddle.getPaddleDestination())
			{
				//move the paddle
				gamePaddle.move();

				//send a request to refresh the display
				gameView.postInvalidate();
			}
			try
			{
				PaddleMover.sleep(3);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}