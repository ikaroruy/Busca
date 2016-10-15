/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca;

import java.util.Random;

/**
 *
 * @author dunkelheit
 */
public class Busca {

//    public static void buscaSeq(int v[], int n, int k) {
//
//        int i;
//        int cont = 0;
//        for (i = 0; i < n; i++) {
//            cont++;
//            if(v[i] == k)
//            System.out.println("Numero encontrado");
//        }
//        System.out.println(cont);
//
//    }

     public static int buscaSeqOrd(int v[], int n, int k) {

        int i;
        int cont = 0;
        for (i = 0; i < n; i++) {
            if(v[i] == k) return i;
            if(v[i] > k) return -1;
            cont++;
        }
        System.out.println(cont);
        return -1;
    }

    public static void buscaBin(int v[], int n, int k) {
//        ArrayList<Integer> arraySoma = new ArrayList();
//        int somaArray = 0;
//        float media;
        int inicio = 0;
        int fim = n-1;
        int centro;
        int cont = 0;
        while(inicio <= fim) {
            centro = inicio+(fim-inicio)/2;
            if(k == v[centro]){
                System.out.println("Numero encontrado   ");
                break;
            }
            else if(k > v[centro]) {
                inicio = centro+1;
            }
            else {
                fim = centro-1;
            }
            cont++;
//            arraySoma.add(cont);
        }
//        for(int i = 0; i < arraySoma.size(); i++){
//            somaArray += arraySoma.get(i);
//        }
//        media = somaArray/arraySoma.size();
//        System.out.println(media);
        System.out.println(cont);
    }
     
    public static void buscaInt(int v[], int n, int k, int maior, int menor) {
//        ArrayList<Integer> arraySoma = new ArrayList();
//        int somaArray = 0;
//        float media;
        int inicio = 0;
        int fim = k-1;
        int centro;
        int cont = 0;
        while(inicio <= fim) {
            centro = (inicio+(fim - inicio) * (n - menor) / (maior - menor));
            if(v[centro] == n) {
                System.out.println("Numero encontrado");
                break;
            }
            else if(v[centro] < n) {
                inicio = centro+1;
            }
            else  {
                fim = centro -1;
            }
            cont++;
        }
//     System.out.println(cont);
    }
    
     public static void buscaIntRob(int v[], int n, int k, int maior, int menor) {
        int inicio = 0;
        int fim = k-1;
        int centro;
        int centroProvavel;
        int Int;
        int cont = 0;
        while(inicio < fim) {
            Int = (int) Math.sqrt(fim - inicio + 1);
            centro = (inicio+(fim - inicio) * (n - menor) / (maior - menor));
            centroProvavel = fim - Int < ((centro >= inicio + Int) ? centro : inicio + Int) ? fim - Int : ((centro >= inicio + Int) ? centro : inicio + Int);
            if (centroProvavel < 0) centroProvavel = 0;    
            if(v[centroProvavel] == n) {
                System.out.println("Numero encontrado");
                break;
            }
            else if(v[centroProvavel] < n) {
                inicio = centroProvavel+1;
            }
            else  {
                fim = centroProvavel -1;
            }
            cont++;
            System.out.println(cont);
        }
     System.out.println("Nao achou");
    }
     

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] elementos = new int[40000];
        Random r = new Random();

        int valorBuscado = 10750;

        for (int j = 0; j < elementos.length-1; j++) {
            for (int i = 0; i < elementos.length-1; i++) {
                elementos[i] = r.nextInt(elementos.length);
            System.out.println(elementos[i]);
            }


            buscaBin(elementos, elementos.length - 1, valorBuscado);
            buscaInt(elementos, valorBuscado, elementos.length - 1, 40000, 1);
            buscaIntRob(elementos, valorBuscado, elementos.length - 1, 40000, 1);
        }

    }

}
