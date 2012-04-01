package iAndroid.PingPong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/*
 * This class is responsible for drawing a paddle
 */
public class PaddleView extends View
{

	private Paddle paddle; //our paddle to be drawn
	private Paint paddlePaint; //the paint to paint the paddle with

	//initialize our view
	public PaddleView(Context context, Paddle newPaddle)
	{
		super(context);

		this.paddle = newPaddle;
	}

	//returns the paint that should be used to paint the paddle
	private Paint getPaddlePaint()
	{
		if (paddlePaint == null)
		{
			paddlePaint = new Paint();
			paddlePaint.setStrokeWidth(2);
			paddlePaint.setColor(Color.BLUE);
		}

		return paddlePaint;
	}

	//do the actual drawing itself
	@Override
	public void onDraw(Canvas canvas)
	{
		int left,right,top,bottom;

		left = paddle.getLeft();
		right = paddle.getRight();
		top = paddle.getTop();
		bottom = paddle.getBottom();

		// Drawing the paddle
		canvas.drawRect(left, top, right, bottom, getPaddlePaint());
	 }
}