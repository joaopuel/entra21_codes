package Exercicios_Aula;

import java.util.Scanner;

public class Sla {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] mapa = {
                {1,0,0,0,0,0,0,0},
                {1,0,0,0,0,1,1,0},
                {0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,0,0,1,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
        };

        char x = '1';
        int y =  x;

        System.out.println(x);
        System.out.println(y);

    }
}
