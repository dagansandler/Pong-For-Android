/**
 * 
 */
package iAndroid.PingPong;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * @author Dagan
 * 
 */
public class PingPongView extends View {

	private BallView ballV;
	private PaddleView bottomPaddleV;
	private PaddleView topPaddleV;

	public PingPongView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setViews(BallView newBV, PaddleView newBP, PaddleView newTP) {
		this.ballV = newBV;
		this.bottomPaddleV = newBP;
		this.topPaddleV = newTP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		this.ballV.onDraw(canvas);
		this.topPaddleV.onDraw(canvas);
		this.bottomPaddleV.onDraw(canvas);

	}

}
