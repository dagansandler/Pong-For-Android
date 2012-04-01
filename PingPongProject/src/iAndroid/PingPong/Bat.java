package iAndroid.PingPong;

public class Bat {

	int x;
	int y;

	int width = 100;
	int height = 10;

	public Bat(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	int getWidth() {
		return width;
	}

	int getHeight() {
		return height;
	}
}
