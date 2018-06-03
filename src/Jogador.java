
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author feo
 */
public class Jogador extends CanvasJogo{
    
    private int contadorPa;
    private int contadorDinamite = 3;
    private int contadorDetector = 2;
    private int contadorEscavadeiraLinha = 1;
    private int contadorEscavadeiraColuna = 1;
    
    private int pontos;
    private int acertos;
    private int acertosMax;
    
    public void mouseClick(int tipo, int x, int y){
        if(tipo == 1 && contadorPa > 0 && getMatrizNum(x, y) != 6 && getMatrizNum(x, y) != 7){
            if(getMatrizNum(x, y) == 0 || getMatrizNum(x, y) == 8){
		setMatrizNum(x, y, 6);
                perdePontos();
            }           
            else {
                setMatrizNum(x, y, 7);
                ganhaPontos();
                somaAcertos();
            }
            contadorPa--;
        }
        else if(tipo == 2 && contadorDinamite > 0 && getMatrizNum(x, y) != 6 && getMatrizNum(x, y) != 7 && getMatrizNum(x+1, y) != 6 && getMatrizNum(x+1, y) != 7 && getMatrizNum(x, y+1) != 6 && getMatrizNum(x, y+1) != 7 && getMatrizNum(x+1, y+1) != 6 && getMatrizNum(x+1, y+1) != 7){
            if(getMatrizNum(x, y) == 0 || getMatrizNum(x, y) == 8){
		setMatrizNum(x, y, 6);
            }          
            else {
                setMatrizNum(x, y, 7);
                ganhaPontos();
                somaAcertos();
            } 
            
            if(getMatrizNum(x+1, y) == 0 || getMatrizNum(x+1, y) == 8){
		setMatrizNum(x+1, y, 6);
            }           
            else {
                setMatrizNum(x+1, y, 7);
                ganhaPontos();
                somaAcertos();
            } 
            
            if(getMatrizNum(x, y+1) == 0 || getMatrizNum(x, y+1) == 8){
		setMatrizNum(x, y+1, 6);
            }           
            else {
                setMatrizNum(x, y+1, 7);
                ganhaPontos();
                somaAcertos();
            }   
            
            if(getMatrizNum(x+1, y+1) == 0 || getMatrizNum(x+1, y+1) == 8){
		setMatrizNum(x+1, y+1, 6);
            }           
            else {
                setMatrizNum(x+1, y+1, 7);
                ganhaPontos();
                somaAcertos();
            }
            contadorDinamite--;
        }
        
        else if(tipo == 3 && contadorDetector > 0 && getMatrizNum(x, y) != 6 && getMatrizNum(x, y) != 7 && getMatrizNum(x+1, y) != 6 && getMatrizNum(x+1, y) != 7 && getMatrizNum(x, y+1) != 6 && getMatrizNum(x, y+1) != 7 && getMatrizNum(x+1, y+1) != 6 && getMatrizNum(x+1, y+1) != 7 && getMatrizNum(x, y) != 8 && getMatrizNum(x, y) != 9 && getMatrizNum(x+1, y) != 8 && getMatrizNum(x+1, y) != 9 && getMatrizNum(x, y+1) != 8 && getMatrizNum(x, y+1) != 9 && getMatrizNum(x+1, y+1) != 8 && getMatrizNum(x+1, y+1) != 9){
            if(getMatrizNum(x, y) == 0){
		setMatrizNum(x, y, 8);
            }          
            else {
                setMatrizNum(x, y, 9);
            } 
            
            if(getMatrizNum(x+1, y) == 0){
		setMatrizNum(x+1, y, 8);
            }           
            else {
                setMatrizNum(x+1, y, 9);
            } 
            
            if(getMatrizNum(x, y+1) == 0){
		setMatrizNum(x, y+1, 8);
            }           
            else {
                setMatrizNum(x, y+1, 9);
            }   
            
            if(getMatrizNum(x+1, y+1) == 0){
		setMatrizNum(x+1, y+1, 8);
            }           
            else {
                setMatrizNum(x+1, y+1, 9);
            }
            contadorDetector--;
        }
        else if(tipo == 4 && contadorEscavadeiraLinha > 0){
            for(int contador = 0; contador < getLargura(); contador++){
                if(getMatrizNum(contador, y) == 0 || getMatrizNum(contador, y) == 8){
                    setMatrizNum(contador, y, 6);
                }
                else if(getMatrizNum(contador, y) == 6){
                    setMatrizNum(contador, y, 6);
                }
                 else if(getMatrizNum(contador, y) == 7){
                    setMatrizNum(contador, y, 7);
                }           
                else {
                    setMatrizNum(contador, y, 7);
                    ganhaPontos();
                    somaAcertos();
                }
            }
            contadorEscavadeiraLinha--;
        }
        else if(tipo == 5 && contadorEscavadeiraColuna > 0){
            for(int contador = 0; contador < getAltura(); contador++){
                if(getMatrizNum(x, contador) == 0 || getMatrizNum(x, y) == 8){
                    setMatrizNum(x, contador, 6);
                }
                else if(getMatrizNum(x, contador) == 6){
                    setMatrizNum(x, contador, 6);
                }
                 else if(getMatrizNum(x, contador) == 7){
                    setMatrizNum(x, contador, 7);
                }           
                else {
                    setMatrizNum(x, contador, 7);
                    ganhaPontos();
                    somaAcertos();
                }
            }
            contadorEscavadeiraColuna--;            
        }
        
        else if(tipo == 1 && contadorPa == 0){
            JOptionPane.showMessageDialog(null,"Suas pás acabaram");
        }
        else if(tipo == 2 && contadorDinamite == 0){
            JOptionPane.showMessageDialog(null,"Suas dinamites acabaram");
        }
        else if(tipo == 3 && contadorDetector == 0){
            JOptionPane.showMessageDialog(null,"Seus detectores acabaram");
        }
        else if(tipo == 4 && contadorEscavadeiraLinha == 0){
            JOptionPane.showMessageDialog(null,"Suas escavadeiras de linha acabaram");
        }
        else if(tipo == 5 && contadorEscavadeiraColuna == 0){
            JOptionPane.showMessageDialog(null,"Suas escavadeiras de coluna acabaram");
        }
        
        if(this.acertos == this.acertosMax){
            JOptionPane.showMessageDialog(null,"Você Ganhou!");
            System.exit(0);
        }
        
        if(contadorPa == 0 && contadorDinamite == 0 && contadorDetector == 0 && contadorEscavadeiraLinha == 0 && contadorEscavadeiraColuna == 0){
            JOptionPane.showMessageDialog(null,"O jogo acabou ;-;");
            System.exit(0);
        }
    }
    
    public void setContadorPa(int quantidade){
        this.contadorPa = quantidade;
    }
    
    public int getContadorPa(){
        return this.contadorPa;
    }
    public void setContadorDinamite(int quantidade){
        this.contadorDinamite = quantidade;
    }
    
    public int getContadorDinamite(){
        return this.contadorDinamite;
    }
    public void setContadorDetector(int quantidade){
        this.contadorDetector = quantidade;
    }
    
    public int getContadorDetector(){
        return this.contadorDetector;
    }
    public void setContadorEscavadeiraLinha(int quantidade){
        this.contadorEscavadeiraLinha = quantidade;
    }
    
    public int getContadorEscavadeiraLinha(){
        return this.contadorEscavadeiraLinha;
    }
    public void setContadorEscavadeiraColuna(int quantidade){
        this.contadorEscavadeiraColuna = quantidade;
    }
    
    public int getContadorEscavadeiraColuna(){
        return this.contadorEscavadeiraColuna;
    }
    
    public void ganhaPontos(){
        this.pontos = this.pontos + 100;
    }
    public void perdePontos(){
        this.pontos = this.pontos - 20;
    }
    
    public void setAcertosMax(int valor){
        this.acertosMax = valor;
    }
    public int getAcertosMax(){
        return this.acertosMax;
    }
    public void somaAcertos(){
        this.acertos++;
    }
}

//JOptionPane.showMessageDialog(null,"mensagem");
