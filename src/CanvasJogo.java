import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class CanvasJogo extends Canvas {
	
	public static final int RECT_WIDTH = 80;
	public static final int RECT_HEIGHT = 80;
	public static final int MARGIN = 0;
	
	private int altura = 15;
	private int largura = 15;
	
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
		ImageIcon icon = new ImageIcon("images/blue.png");
		ImageIcon iconShotErro = new ImageIcon("images/red.png");
                ImageIcon iconShotAcerto = new ImageIcon("images/green.png");
		// Prepare an Image object to be used by drawImage()
		final Image img = icon.getImage();
		final Image imgShotErro = iconShotErro.getImage();
                final Image imgShotAcerto = iconShotAcerto.getImage();
		
		for(int i = 0; i < this.largura; i++) {
			for(int j = 0; j < this.altura; j++) {				
				g.drawImage(img, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
				if(explosionMatrix[i][j] == 6) {
					g.drawImage(imgShotErro, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
				}
                                else if(explosionMatrix[i][j] == 7) {
					g.drawImage(imgShotAcerto, i*RECT_WIDTH+MARGIN, j*RECT_HEIGHT+MARGIN, RECT_WIDTH, RECT_HEIGHT, null);
                                   
                                }
			}

		}	
	}
	
	public void setShot(int x, int y) {
            if(explosionMatrix[x][y] == 0){
		explosionMatrix[x][y] = 6;
            }
            else if(explosionMatrix[x][y] == 6){
                explosionMatrix[x][y] = 6;
            }
             else if(explosionMatrix[x][y] == 7){
                explosionMatrix[x][y] = 7;
            }           
            else {
                explosionMatrix[x][y] = 7;
            }
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
        
        public void setMatrizNum(int j, int i, int matrizNum){
            this.explosionMatrix[j][i] = matrizNum;
        }
	
}
