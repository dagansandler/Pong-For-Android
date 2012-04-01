package iAndroid.PingPong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BallView extends View {

	private Ball theBall;
	private Paint ballPaint;

	public BallView(Context context, Ball ball) {
		super(context);
		this.theBall = ball;
	}

	private Paint getBallPaint() {
		if (ballPaint == null) {
			ballPaint = new Paint();
			ballPaint.setStrokeWidth(2);
			ballPaint.setColor(Color.WHITE);
		}
		return ballPaint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawCircle(theBall.getX(), theBall.getY(), 15, getBallPaint());
	}

}
