package iAndroid.PingPong;

public class PongGame extends Thread {
	private Ball gameBall;
	private Paddle topPaddle;
	private Paddle bottomPaddle;
	private PingPongView gameView;

	public PongGame(Ball theBall, Paddle bottomPaddle, Paddle topPaddle, PingPongView mainView) {
		this.gameBall = theBall;
		this.topPaddle = topPaddle;
		this.bottomPaddle = bottomPaddle;
		this.gameView = mainView;
	}

	@Override
	public void run() {
		while (1 < 2) {
			this.gameBall.move();
			
			checkForHit();
			
			this.topPaddle.setPaddleDestination(this.gameBall.getX());

			this.gameView.postInvalidate();

			try {
				PongGame.sleep(2);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void checkForHit() {
		
		// Checking if the ball had hit the paddle
		if (gameBall.getBottom() >= bottomPaddle.getTop())
		{
			// check if the paddle is in the right place
			if ((gameBall.getRight() > bottomPaddle.getLeft()) &&
			    (gameBall.getLeft() < bottomPaddle.getRight()))
			{
				//The ball had hit the paddle - so it should be bounced
				gameBall.bounce();
			}
			else
			{
				//The ball had missed the paddle - player looses - restart the game
				gameBall.restart();
			}
		} else if (gameBall.getTop() <= topPaddle.getBottom()) {
			// check if the paddle is in the right place
			if ((gameBall.getRight() > topPaddle.getLeft()) &&
			    (gameBall.getLeft() < topPaddle.getRight()))
			{
				//The ball had hit the paddle - so it should be bounced
				gameBall.bounce();
			}
			else
			{
				//The ball had missed the paddle - player looses - restart the game
				gameBall.restart();
			}
		}
		
	}

}
