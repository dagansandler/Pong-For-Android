package iAndroid.PingPong;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class PingPong extends Activity {

	private PingPongView gameView;
	private Ball ball;
	private Bat bottomBat;
	private Bat topBat;
	
	private PongGame gameThread;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// hide app's title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// hide status bar
		final Window win = getWindow();
		win.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		int midX = this.getWindowManager().getDefaultDisplay().getWidth() / 2;
		int midY = this.getWindowManager().getDefaultDisplay().getHeight() / 2;

		ball = new Ball(midX, midY, this.getWindowManager().getDefaultDisplay()
				.getWidth(), this.getWindowManager().getDefaultDisplay()
				.getHeight());
		BallView ballView = new BallView(this, ball);

		topBat = new Bat(midX - 50, 10);
		bottomBat = new Bat(midX - 50, midY * 2 - 20);
		BatView topBatView = new BatView(this, topBat);
		BatView bottomBatView = new BatView(this, bottomBat);

		this.gameView = new PingPongView(this);

		this.gameView.setBallView(ballView);
		this.gameView.setBottomBatView(bottomBatView);
		this.gameView.setTopBatView(topBatView);

		this.gameView.setPadding(5, 5, 5, 5);
		setContentView(gameView);

		gameThread = new PongGame(ball, gameView);
		gameThread.start();
	}
}