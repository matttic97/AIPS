
public class Izziv3 {
	
	public static void main(String[] args) {
	
//		StdDraw.square(0.2, 0.8, 0.1);
//        StdDraw.filledSquare(0.8, 0.8, 0.2);
//        StdDraw.circle(0.8, 0.2, 0.2);
//
//        StdDraw.setPenColor(StdDraw.BOOK_RED);
//        StdDraw.setPenRadius(0.02);
//        StdDraw.arc(0.8, 0.2, 0.1, 200, 45);
//
//        // draw a blue diamond
//        StdDraw.setPenRadius();
//        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
//        double[] x = { 0.1, 0.2, 0.3, 0.2 };
//        double[] y = { 0.2, 0.3, 0.2, 0.1 };
//        StdDraw.filledPolygon(x, y);
//
//        // text
//        StdDraw.setPenColor(StdDraw.BLACK);
//        StdDraw.text(0.2, 0.5, "black text");
//        StdDraw.setPenColor(StdDraw.WHITE);
//        StdDraw.text(0.8, 0.8, "white text");
		
		StdDraw.setCanvasSize(1500, 800);
		StdDraw.setXscale(-1, 10);
		StdDraw.setYscale((int)(Math.log(100)/Math.log(2))+1, 1);
		Drevo drevo = new Drevo(2, 2, 1);
		drevo.drawLevelorder();
		
	}

}
