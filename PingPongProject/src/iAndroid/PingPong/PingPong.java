package iAndroid.PingPong;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class PingPong extends Activity {

	private PingPongView gameView;
	private Ball ball;
	private Paddle bottomPaddle;
	private Paddle topPaddle;
	
	private PongGame gameThread;
	private PaddleMover aiThread;
	private PaddleMover playerThread;
	
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

		topPaddle = new Paddle(midX, 10, midX*2);
		bottomPaddle = new Paddle(midX, midY * 2 - 20, midX*2);
		PaddleView topPaddleView = new PaddleView(this, topPaddle);
		PaddleView bottomPaddleView = new PaddleView(this, bottomPaddle);

		this.gameView = new PingPongView(this);

		this.gameView.setViews(ballView, bottomPaddleView, topPaddleView);

		this.gameView.setPadding(5, 5, 5, 5);
		setContentView(gameView);

		gameThread = new PongGame(ball, bottomPaddle, topPaddle, gameView);
		gameThread.start();
		
		aiThread = new PaddleMover(topPaddle, gameView);
		aiThread.start();
		
		playerThread = new PaddleMover(bottomPaddle, gameView);
		playerThread.start();
	}
	
    //This method is automatically called when the user touches the screen
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
    	float destination;

    	//get the x coordinate of users' press
    	destination = event.getX();

    	//notify the paddle mover thread regarding the new destination
    	bottomPaddle.setPaddleDestination(destination);

	    return true;
    }
}