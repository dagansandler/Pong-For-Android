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
	private BatView bottomBat;
	private BatView topBat;
	
	public PingPongView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setBallView(BallView newBV) {
		this.ballV = newBV;
	}
	
	public void setBottomBatView(BatView newBV) {
		this.bottomBat = newBV;
	}

	public void setTopBatView(BatView newBV) {
		this.topBat = newBV;
	}
	
	/* (non-Javadoc)
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		this.ballV.onDraw(canvas);
		this.topBat.onDraw(canvas);
		this.bottomBat.onDraw(canvas);
		
	}

	
}
