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
    
    private int contadorPa = 0;
    private int contadorDinamite = 0;
    private int contadorDetector = 0;
    private int contadorEscavadeiraLinha = 0;
    private int contadorEscavadeiraColuna = 0;
    
    public void mouseClick(int tipo, int x, int y){
        if(tipo == 1){
            if(getMatrizNum(x, y) == 0){
		setMatrizNum(x, y, 6);
            }
            else if(getMatrizNum(x, y) == 6){
                setMatrizNum(x, y, 6);
            }
             else if(getMatrizNum(x, y) == 7){
                setMatrizNum(x, y, 7);
            }           
            else {
                setMatrizNum(x, y, 7);
            }
        }
        else if(tipo == 2){
            if(getMatrizNum(x, y) == 0){
		setMatrizNum(x, y, 6);
            }
            else if(getMatrizNum(x, y) == 6){
                setMatrizNum(x, y, 6);
            }
             else if(getMatrizNum(x, y) == 7){
                setMatrizNum(x, y, 7);
            }           
            else {
                setMatrizNum(x, y, 7);
            } 
            
            if(getMatrizNum(x+1, y) == 0){
		setMatrizNum(x+1, y, 6);
            }
            else if(getMatrizNum(x+1, y) == 6){
                setMatrizNum(x+1, y, 6);
            }
             else if(getMatrizNum(x+1, y) == 7){
                setMatrizNum(x+1, y, 7);
            }           
            else {
                setMatrizNum(x+1, y, 7);
            } 
            
            if(getMatrizNum(x, y+1) == 0){
		setMatrizNum(x, y+1, 6);
            }
            else if(getMatrizNum(x, y+1) == 6){
                setMatrizNum(x, y+1, 6);
            }
             else if(getMatrizNum(x, y+1) == 7){
                setMatrizNum(x, y+1, 7);
            }           
            else {
                setMatrizNum(x, y+1, 7);
            }   
            
            if(getMatrizNum(x+1, y+1) == 0){
		setMatrizNum(x+1, y+1, 6);
            }
            else if(getMatrizNum(x+1, y+1) == 6){
                setMatrizNum(x+1, y+1, 6);
            }
             else if(getMatrizNum(x+1, y+1) == 7){
                setMatrizNum(x+1, y+1, 7);
            }           
            else {
                setMatrizNum(x+1, y+1, 7);
            }
        }
        else if(tipo == 3){
            
        }
        else if(tipo == 4){
            for(int contador = 0; contador < getLargura(); contador++){
                if(getMatrizNum(contador, y) == 0){
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
                }
            }             
        }
        else if(tipo == 5){
            for(int contador = 0; contador < getAltura(); contador++){
                if(getMatrizNum(x, contador) == 0){
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
                }
            }            
        }
    }
    
}
