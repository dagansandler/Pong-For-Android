package iAndroid.PingPong;

public class PongGame extends Thread {
	private Ball gameBall;
	private PingPongView gameView;

	public PongGame(Ball theBall, PingPongView mainView) {
		this.gameBall = theBall;
		this.gameView = mainView;
	}

	@Override
	public void run() {
		while (1 < 2) {
			this.gameBall.moveBall();
			this.gameView.postInvalidate();

			try {
				PongGame.sleep(2);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
