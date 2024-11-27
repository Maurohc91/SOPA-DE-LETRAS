package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //demanem a l'usuari el tamany de la matriu

        System.out.println("Introduce el número de filas (m): ");
        int m = teclado.nextInt(); //numero de files
        System.out.println("Introduce el número de columnas (n): ");
        int n = teclado.nextInt(); //numero de columnas

        String matriz [][] = new String[m][n];

        //inicialitzem la matriu
        for (int i = 0; i < m; i++) {
            System.out.println("Introduce fila " + (i+1) + " debe contener " + n + " letras.");
            String fila = teclado.next();

            //validem que la fila continga exactament les lletres correctes i que siguen lletres
            while (!fila.matches("[a-zA-Z]{" + n + "}")){
                System.out.println("ERROR. Vuelve a introducir de nuevo.");
                fila = teclado.next();
            }

            //plenem la fila en la matriu
            for (int j = 0; j < n; j++) {
                matriz[i][j] = String.valueOf(fila.charAt(j));
            }
        }
        //mostrem la matriu

        System.out.print("La sopa de letras es la siguiente: ");
        System.out.println();
        for (String[] filas : matriz){
            for (String columnas : filas) {
                System.out.print(columnas + " ");
            }
            System.out.println();
        }
        //demanem la paraula a buscar
        System.out.println("Introduce la palabra a buscar:");
        String palabra = teclado.next();

        //per a vore que la paraula nomes conte lletres

        while (!palabra.matches("[a-zA-Z]+")) {
            System.out.println("ERROR. Vuelva a introducir la palabra: ");
            palabra = teclado.next();
        }

        //ara buscarem la paraula en la matriu
        boolean encontrada = false;

        for (int i = 0; i < m && !encontrada; i++) {
            for (int j = 0; j < n && !encontrada; j++) {
                //per a coincidencia horitzontal
                boolean horizontal = true;
                if (j + palabra.length() <= n) {
                    for (int k = 0; k < palabra.length(); k++) {
                        if (!matriz[i][j+k].equalsIgnoreCase(String.valueOf(palabra.charAt(k)))) {
                            horizontal = false;
                            break;
                        }
                    }
                }else{
                    horizontal=false;
                }

                //per a coincidencia vertical
                boolean vertical = true;
                if (i + palabra.length() <=m) {
                    for (int k = 0; k < palabra.length(); k++) {
                        if (!matriz [i+k][j].equalsIgnoreCase(String.valueOf(palabra.charAt(k)))) {
                            vertical = false;
                            break;
                        }
                    }
                }else {
                    vertical=false;
                }
                //per a vore si la paraula ha sigut encontrada
                if (horizontal || vertical) {
                    System.out.println("PALABRA ENCONTRADA. POSICION: " + i + "," + j);
                    encontrada=true;
                }
            }
        }
        if (!encontrada) {
            System.out.println("La palabra no existe.");
        }

    }
}