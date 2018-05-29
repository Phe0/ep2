import java.io.File;
import java.util.Scanner;


public class Arquivo {
    
    private int largura;
    private int altura;   
    
    private int[][] matriz;
    
    private int quantidadeTamanho1;
    private int quantidadeTamanho2;
    private int quantidadeTamanho3;        
    private int quantidadeTamanho4;        
    private int quantidadeTamanho5;
    
    public Arquivo(String origem) throws Exception{
        String[] conteudo;
        int tamanho, contador = 0;
        String matrizTemporaria = "";
        
        Scanner leitor = new Scanner(new File(origem)); 
        
        String linha = leitor.nextLine();
        
        linha = leitor.nextLine();
        
        conteudo = linha.split(" ");
        this.largura = Integer.parseInt(conteudo[0]);
        this.altura = Integer.parseInt(conteudo[1]);
        
        linha = leitor.nextLine();
        linha = leitor.nextLine();
        
        for(int i = 0; i < this.altura; i++){
            linha = leitor.nextLine();
            matrizTemporaria += linha;
        }
        
        tamanho = this.altura*this.largura;
        int[] numeros = new int[tamanho];
        
        for(int i = 0; i < tamanho; i++){
             numeros[i] = Integer.parseInt(matrizTemporaria.substring(i, i+1));     
       }
        
       this.matriz = new int[this.altura][this.largura];
       
       for(int i = 0; i < this.altura; i++){
           for(int j = 0; j < this.largura; j++){
               this.matriz[i][j] = numeros[contador];
               contador++;
           }
       }
       
       linha = leitor.nextLine();
       linha = leitor.nextLine();
       
       linha = leitor.nextLine();
       conteudo = linha.split(" ");
       this.quantidadeTamanho1 = Integer.parseInt(conteudo[1]);
       
       linha = leitor.nextLine();
       conteudo = linha.split(" ");
       this.quantidadeTamanho2 = Integer.parseInt(conteudo[1]);
       
       linha = leitor.nextLine();
       conteudo = linha.split(" ");
       this.quantidadeTamanho3 = Integer.parseInt(conteudo[1]);
       
       linha = leitor.nextLine();
       conteudo = linha.split(" ");
       this.quantidadeTamanho4 = Integer.parseInt(conteudo[1]);
       
       linha = leitor.nextLine();
       conteudo = linha.split(" ");
       this.quantidadeTamanho5 = Integer.parseInt(conteudo[1]);
    }
    
    public void setLargura(int largura){
        this.largura = largura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }

    public void setQuantidadeTamanho1(int quantidadeTamanho1){
        this.quantidadeTamanho1 = quantidadeTamanho1;
    }
    public void setQuantidadeTamanho2(int quantidadeTamanho2){
        this.quantidadeTamanho2 = quantidadeTamanho2;
    }
    public void setQuantidadeTamanho3(int quantidadeTamanho3){
        this.quantidadeTamanho3 = quantidadeTamanho3;
    }
    public void setQuantidadeTamanho4(int quantidadeTamanho4){
        this.quantidadeTamanho4 = quantidadeTamanho4;
    }
    public void setQuantidadeTamanho5(int quantidadeTamanho5){
        this.quantidadeTamanho5 = quantidadeTamanho5;
    } 
    
    
    public int getLargura(){
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public int getQuantidadeTamanho1(){
        return this.quantidadeTamanho1;
    }
    public int getQuantidadeTamanho2(){
        return this.quantidadeTamanho2;
    }
    public int getQuantidadeTamanho3(){
        return this.quantidadeTamanho3;
    }
    public int getQuantidadeTamanho4(){
        return this.quantidadeTamanho4;
    }
    public int getQuantidadeTamanho5(){
        return this.quantidadeTamanho5;
    }    
    
}
