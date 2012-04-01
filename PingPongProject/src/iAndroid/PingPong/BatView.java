package iAndroid.PingPong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BatView extends View {

	private Bat theBat;
	private Paint batPaint;

	public BatView(Context context, Bat newBat) {
		super(context);

		this.theBat = newBat;
	}

	private Paint getBatPaint() {
		if (batPaint == null) {
			batPaint = new Paint();
			batPaint.setStrokeWidth(2);
			batPaint.setColor(Color.WHITE);
		}
		return batPaint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRect(theBat.getX(), theBat.getY(), theBat.getX()+theBat.getWidth(), theBat.getY()+theBat.getHeight(), getBatPaint());
	}
}
