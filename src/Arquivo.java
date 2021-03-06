import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Arquivo extends JFrame{
    
    private Jogador jogador = new Jogador();
    
    private CanvasThread atualizarTela = new CanvasThread(jogador);
    
    private int largura;
    private int altura; 
    
    private int tipo = 1;
    
    private int matriz = 0;
    
    private int quantidadeCristais[] = new int [5];
    
    public Arquivo(){
    }
    
    public void setLargura(int largura){
        this.largura = largura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    
    public int getLargura(){
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public void abreArquivo(){
        JFileChooser seletor = new JFileChooser();
        int retornarValor = seletor.showOpenDialog(this);
        int contador = 0;
        if(retornarValor == JFileChooser.APPROVE_OPTION){
            File arquivo = seletor.getSelectedFile();
            
            try {
                FileReader leitorArquivo = new FileReader( arquivo.getAbsolutePath() );
                BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
                
                int i = 0, k = 0;
                String linha = lerArquivo.readLine();
                contador++;
                
                while (linha != null) {
                    if(contador == 2){
                        String[] separadorDeTexto = linha.split(" ");
                        this.largura = Integer.parseInt(separadorDeTexto[0]);
                        this.altura = Integer.parseInt(separadorDeTexto[1]);
                        jogador.setLargura(this.largura);
                        jogador.setAltura(this.altura);
                    }
                    
                    if(contador >= 5 && contador < 5 + this.altura){
                        char[] arrayValores = linha.toCharArray();
                        
                        //this.matriz = new int[this.altura][this.largura];
                        
                        for (int j = 0; j < arrayValores.length; j++){
                            this.matriz = Integer.parseInt(String.valueOf(arrayValores[j]));
                            jogador.setMatrizNum(j, i , this.matriz);
                        }
                        
                        i++;
                    }
                    
                    if(contador >= this.altura + 7){
                        String cristais[] = linha.split(" ");
                        this.quantidadeCristais[k] = Integer.parseInt(cristais[1]);
                        k++;  
                    }
                    
                    linha = lerArquivo.readLine();
                    contador++;
                }
                
                jogador.setAcertosMax(this.quantidadeCristais[0]+this.quantidadeCristais[1]+this.quantidadeCristais[2]+this.quantidadeCristais[3]+this.quantidadeCristais[4]);                
                jogador.setContadorPa((jogador.getLargura()*jogador.getAltura()/3));
                
                leitorArquivo.close();
                
            }catch (IOException ex) {
                System.out.println("problem accessing file" + arquivo.getAbsolutePath());
            }
                
        }
        if(contador > 0) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            
            getContentPane().setLayout(new BorderLayout());
            setTitle("Escavação");
            getContentPane().add(jogador, BorderLayout.CENTER);
            
            if(jogador.RECT_WIDTH * jogador.getLargura() > 700){     
                setSize((jogador.RECT_WIDTH * jogador.getLargura()), (jogador.RECT_HEIGHT * jogador.getAltura()));
            }
            else{
                int falta;
                falta = 700 - (jogador.RECT_WIDTH * jogador.getLargura());
                setSize((jogador.RECT_WIDTH * jogador.getLargura() + falta), (jogador.RECT_HEIGHT * jogador.getAltura()));
            }
            
            JButton botaoPa = new JButton("Pá x"+jogador.getContadorPa());
            JButton botaoDinamite = new JButton("Dinamite x"+jogador.getContadorDinamite());  
            JButton botaoDetector = new JButton("Detector x"+jogador.getContadorDetector());
            JButton botaoEscavadeiraLinha = new JButton("Escavadeira Linha x"+jogador.getContadorEscavadeiraLinha());
            JButton botaoEscavadeiraColuna = new JButton("Escavadeira Coluna x"+jogador.getContadorEscavadeiraColuna());
            
            JPanel panel = new JPanel();
            
            JLabel pontos = new JLabel("Pontos: "+jogador.getPontos());
            
            panel.add(botaoPa);
            panel.add(botaoDinamite); 
            panel.add(botaoDetector);   
            panel.add(botaoEscavadeiraLinha);
            panel.add(botaoEscavadeiraColuna);
            panel.add(pontos);
            
            getContentPane().add(panel, BorderLayout.SOUTH);
            
            setVisible(true);
            
            atualizarTela.start();
            
            
            botaoPa.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botaoPaActionPerformed(evt);
                }
            });
            
            botaoDinamite.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botaoDinamiteActionPerformed(evt);
                }
            });
            
            botaoDetector.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botaoDetectorActionPerformed(evt);
                }
            });
            
            botaoEscavadeiraLinha.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botaoEscavadeiraLinhaActionPerformed(evt);
                }
            });
           
            botaoEscavadeiraColuna.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botaoEscavadeiraColunaActionPerformed(evt);
                }
            });
            
            jogador.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();

                    int x_pos = x / jogador.RECT_WIDTH;
                    int y_pos = y / jogador.RECT_HEIGHT;

                    jogador.mouseClick(getTipo(),x_pos, y_pos);
                    
                    pontos.setText("Pontos: "+ jogador.getPontos() );
                    
                    botaoPa.setText("Pá x"+jogador.getContadorPa());
                    botaoDinamite.setText("Dinamite x"+jogador.getContadorDinamite());
                    botaoDetector.setText("Detector x"+jogador.getContadorDetector());
                    botaoEscavadeiraLinha.setText("Escavadeira Linha x"+jogador.getContadorEscavadeiraLinha());
                    botaoEscavadeiraColuna.setText("Escavadeira Coluna x"+jogador.getContadorEscavadeiraColuna());

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            }); 

            
        }

        else {
            System.out.println("File acess cancelled by user");
        }
    }
    
    private void botaoPaActionPerformed(java.awt.event.ActionEvent evt){
        this.tipo = 1;
    }
    
    private void botaoDinamiteActionPerformed(java.awt.event.ActionEvent evt){
        this.tipo = 2;
    }
    
    private void botaoDetectorActionPerformed(java.awt.event.ActionEvent evt){
        this.tipo = 3;
    }        

    private void botaoEscavadeiraLinhaActionPerformed(java.awt.event.ActionEvent evt){
        this.tipo = 4;
    }
    
    private void botaoEscavadeiraColunaActionPerformed(java.awt.event.ActionEvent evt){
        this.tipo = 5;
    }
    
    public int getTipo(){
        return this.tipo;
    }
}
