import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class CanvasJogo extends Canvas {
	
	public static final int RECT_WIDTH = 80;
	public static final int RECT_HEIGHT = 80;
	public static final int MARGIN = 0;
	
	private int altura = 8;
	private int largura = 7;
	
	private int animationCounter = 0;
	private int animationCounterDirection = 0;
	
	private int [][] explosionMatrix = new int[altura][largura];
	
	@Override
	public void paint(Graphics g) {
		
		if(animationCounterDirection == 0) {
			if (animationCounter < 6) {
				animationCounter++;
			}
			else {
				animationCounterDirection = 1;
			}
		}
		else {
			if (animationCounter > 0) {
				animationCounter--;
			}
			else {
				animationCounterDirection = 0;
			}
		}
		
		// Prepare an ImageIcon
		ImageIcon icon = new ImageIcon("images/ondas_" + String.valueOf(animationCounter) + ".jpg");
		ImageIcon iconShot = new ImageIcon("images/explosion.png");
		// Prepare an Image object to be used by drawImage()
		final Image img = icon.getImage();
		final Image imgShot = iconShot.getImage();
		
		for(int i = 0; i < this.largura; i++) {
			for(int j = 0; j < this.altura; j++) {				
				g.drawImage(img, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
				if(explosionMatrix[i][j] == 1) {
					g.drawImage(imgShot, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
				}
			}

		}	
	}
	
	public void setShot(int x, int y) {
		explosionMatrix[x][y] = 1;
	}

	public int getLargura() {
		return this.largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return this.altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}


	
	
}