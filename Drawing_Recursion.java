// Sirinapha Dube
// Lab D: Recursion

// Sorry. This is all I can do.

import javax.swing.*;

import java.awt.*;

public class AppletTemplate extends JApplet {
	private int x = 200;
	private int limit = 4;
	private int width = 600;
	private int height = 600;

	public void init() {
		setSize(600, 600);
		setBackground(Color.blue);

	}

	public void paint(Graphics pen) {

		int w = (width / 2) - (x / 2);
		int h = (height / 2) - (x / 2);

		pen.fillRect(w, h, x, x);
		pen.setColor(Color.pink);
		if (limit > 0)
			drawSquare(pen, w, h);

	}

	public void drawSquare(Graphics pen, int w, int h) {

		int i = 0;

		pen.fillRect(w - (x / 2), h - (x / 2), x / 2, x / 2);
		drawSquare(w - (x / 2), h - (x / 2), pen, i, 0, x / 2);

		pen.fillRect(w + x, h - (x / 2), x / 2, x / 2);
		drawSquare(w + x, h - (x / 2), pen, i, 1, x / 2);

		pen.fillRect(w + x, h + x, x / 2, x / 2);
		drawSquare(w + x, h + x, pen, i, 2, x / 2);

		pen.fillRect(w - (x / 2), h + x, x / 2, x / 2);
		drawSquare(w - (x / 2), h + x, pen, i, 3, x / 2);

		pen.fillRect(w - (x / 2), h + x, x / 2, x / 2);
		drawSquare(w - (x / 2), h + x, pen, i, 4, x / 2);

	}

	private void drawSquare(int w, int h, Graphics pen, int n, int origin,
			int size) {
		if (n == limit)
			return;

		n++;

		origin = (origin + 2) % 4;

		if (origin != 0) {
			pen.fillRect(w - (size / 2), h - (size / 2), size / 2, size / 2);
			drawSquare(w - (size / 2), h - (size / 2), pen, n, 0, size / 2);

		}
		if (origin != 1) {
			pen.fillRect(w + size, h - (size / 2), size / 2, size / 2);
			drawSquare(w + size, h - (size / 2), pen, n, 1, size / 2);
		}
		if (origin != 2) {
			pen.fillRect(w + size, h + size, size / 2, size / 2);
			drawSquare(w + size, h + size, pen, n, 2, size / 2);
		}
		if (origin != 3) {
			pen.fillRect(w - (size / 2), h + size, size / 2, size / 2);
			drawSquare(w - (size / 2), h + size, pen, n, 3, size / 2);
		}
		if (origin != 4) {
			pen.fillRect(w - (size / 2), h + size, size / 2, size / 2);
			drawSquare(w - (size / 2), h + size, pen, n, 3, size / 2);
		}
	}
}
