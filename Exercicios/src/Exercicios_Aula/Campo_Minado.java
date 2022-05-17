package Exercicios_Aula;

import java.util.Scanner;

public class Campo_Minado{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] mapa = {
                {1,0,0,0,0,0,0,1},
                {1,0,0,0,1,1,0,1},
                {0,1,0,0,0,0,0,0},
                {0,1,0,0,1,1,1,1},
                {0,1,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,0},
                {0,1,1,0,0,0,0,0},
                {0,0,0,0,0,1,1,1},
        };

        int[][] mapa_original = new int[8][8];

        for(int i=0; i<mapa.length; i++)
        {
            System.arraycopy(mapa[i], 0, mapa_original[i], 0, mapa[i].length);
        }

        while(true) {

            mostrar_mapa(mapa, mapa_original);

            System.out.print("Escreva 'Parar' para encerrar o jogo a qualquer momento. \nLinha: ");
            String lin_letra = sc.nextLine();
            int lin = lin_letra.charAt(0);

            if(lin_letra.equals("Parar"))
            {
                break;
            }

            if((lin-49)<0 || (lin-49)>7)
            {
                System.err.println("\nLinha não é válida\n");
                continue;
            }

            System.out.print("Coluna: ");
            String col_letra = sc.nextLine();
            col_letra = col_letra.toUpperCase();
            int col = col_letra.charAt(0);

            if(col_letra.equals("PARAR"))
            {
                break;
            }

            if((col-65)<0 || (col-65)>7)
            {
                System.err.println("\nColuna não é válida\n");
                continue;
            }

            mapa = checa_tabuleiro(lin, col, mapa);

            boolean fim = fim_do_jogo (mapa);

            if(fim)
            {
                System.out.println("Todas as embarcações foram abatidas. Parabéns!!\n");
                break;
            }

            System.out.println("Ainda há embarcações inimigas no mar\n");
            System.out.println("Pressione Enter para continuar");
            sc.nextLine();
        }


        System.out.println("\nObrigado por jogar :)");
    }

    public static boolean fim_do_jogo(int[][] mapa)
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(mapa[i][j]==1)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void mostrar_mapa(int[][] mapa, int [][] mapa_original)
    {
        System.out.println("MAPA:\n");

        System.out.println(ANSI_YELLOW + "\tA\tB\tC\tD\tE\tF\tG\tH");
        for(int i=0; i<8; i++)
        {
            System.out.print(ANSI_YELLOW + i + "\t" + ANSI_RESET);

            for(int j=0; j<8; j++)
            {
                if(mapa[i][j] != mapa_original[i][j])
                {
                    System.out.print(ANSI_GREEN + "O\t" + ANSI_RESET);
                    continue;
                }
                if(mapa[i][j]==2)
                {
                    System.out.print(ANSI_RED + "X\t" + ANSI_RESET);
                    continue;
                }
                System.out.print("□\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int[][] checa_tabuleiro(int lin, int col, int[][] mapa)
    {
        if (mapa[lin - 49][col - 65] == 1) {
            System.out.println("\nVocê acertou o alvo!");
            mapa[lin - 49][col - 65] = 0;
        } else {
            System.out.println("\nBomba afundou no mar");
            mapa[lin - 49][col - 65] = 2;
            mapa_original[lin - 49][col - 65] = 2;
        }
    }
}
