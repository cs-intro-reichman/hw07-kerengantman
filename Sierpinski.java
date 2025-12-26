/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
	}

	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski(int n) {
		sierpinski(n, 0.0, 1.0, 0.5, 0.0, 0.0, Math.sqrt(3) / 2);

	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
			double y1, double y2, double y3) {
		if (n == 0) {
			return;
		}
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);
		double midx12 = (x1 + x2) / 2;
		double midx23 = (x2 + x3) / 2;
		double midx31 = (x3 + x1) / 2;
		double midy12 = (y1 + y2) / 2;
		double midy23 = (y2 + y3) / 2;
		double midy31 = (y3 + y1) / 2;

		sierpinski(n - 1, x1, midx12, midx31, y1, midy12, midy31);
		sierpinski(n - 1, midx12, x2, midx23, midy12, y2, midy23);
		sierpinski(n - 1, midx31, midx23, x3, midy31, midy23, y3);

	}
}
