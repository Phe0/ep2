import java.awt.Graphics;

public class CanvasThread extends Thread {
	private Jogador jogador;
	private boolean running = true; 
	
	public CanvasThread(Jogador jogador) {
		this.jogador = jogador;
	}
	
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jogador.paint(jogador.getGraphics());
		}
	}
}
