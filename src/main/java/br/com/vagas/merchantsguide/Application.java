package br.com.vagas.merchantsguide;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import br.com.vagas.merchantsguide.controller.ExpressionController;

public class Application {
	
	
	 public static void main(String[] args) throws IOException {
		 ExpressionController controller = new ExpressionController();
		 String path = System.getProperty("path");	 
		 helloVagas();
		 if(path.equals(" ") || path == null) {
			 System.out.println("please enter the correct input.txt file path");
		 }else {
			 translate();
			 controller.readFile(path);
		 }
		 
	 }
	 
	 private static void helloVagas() {
		 BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
		 Graphics g = image.getGraphics();
		 g.setFont(new Font("Dialog", Font.PLAIN, 15));
		 Graphics2D graphics = (Graphics2D) g;
		 graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		 graphics.drawString(" Hello VAGAS", 1, 15);

		 for (int y = 0; y < 32; y++) {
		     StringBuilder sb = new StringBuilder();
		     for (int x = 0; x < 100; x++)
		         sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "v" : "@");
		     if (sb.toString().trim().isEmpty()) continue;
		     System.out.println(sb);
		 }
	 }
	 
	 private static void translate() {
		 System.out.println("*******************************************************");
		 System.out.println("**********Translate the values to input.txt************");
		 System.out.println("*******************************************************\n");
	 }

}
