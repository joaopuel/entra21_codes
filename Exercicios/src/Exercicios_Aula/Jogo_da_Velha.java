package Exercicios_Aula;

import java.util.Scanner;

public class Jogo_da_Velha {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] tabuleiro = {{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};

        while(true)
        {
            int pos =0;

            while(true) {
                System.out.println("Informe uma posição para O: ");
                pos = sc.nextInt();

                if (pos < 1 || pos > 9) {
                    System.err.println("Informe uma posição válida!");
                    continue;
                }

                if(checar_tabuleiro(pos, tabuleiro))
                {
                    System.err.println("Informe uma posição válida!");
                    continue;
                }

                break;
            }

            mostrar_tabuleiro('0', pos, tabuleiro);

            while(true)
            {
                System.out.println("Informe uma posição para X: ");
                pos = sc.nextInt();

                if (pos < 1 || pos > 9) {
                    System.err.println("Informe uma posição válida!");
                    continue;
                }

                if(checar_tabuleiro(pos, tabuleiro))
                {
                    System.err.println("Informe uma posição válida!");
                    continue;
                }

                break;
            }

            mostrar_tabuleiro('X', pos, tabuleiro);

        }

    }


    public static void mostrar_tabuleiro(char simb, int pos, char[][] tab)
    {
        int fator_x=0;

        if(pos<4)
        {
            pos-=1;
        } else if (pos<7) {
            pos-=4;
            fator_x=1;
        } else if (pos>6) {
            pos-=7;
            fator_x=2;
        }

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i!=fator_x || j!=pos)
                {
                    System.out.print("\t" + tab[i][j] + "\t");
                    continue;
                }

                tab[i][j] = simb;
                System.out.print("\t" + tab[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean checar_tabuleiro(int pos, char[][] tab)
    {
        int fator_x=0;

        if(pos<4)
        {
            pos-=1;
        } else if (pos<7) {
            pos-=4;
            fator_x=1;
        } else if (pos>6) {
            pos-=7;
            fator_x=2;
        }

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i==fator_x && j==pos)
                {
                    if((tab[i][j])!='-')
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean fim_de_jogo(char simb, char[][] tab)
    {
        int cont = 0;

        //Checar linha
        for(char[] i : tab)
        {
            for(char j : i)
            {
                if(j==simb)
                {
                    cont++;
                }
            }

            if(cont==3)
            {
                return true;
            }

            cont=0;
        }

        //Checar coluna
        for(int j=0; j<3; j++)
        {
            for(int i=0; i<3; i++)
            {
                if(tab[i][j]==simb)
                {
                    cont++;
                }
            }

            if(cont==3)
            {
                return true;
            }

            cont=0;
        }

        int cont_2=0;
        //Checar diagonais
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i==j)
                {
                    if(tab[i][j]==simb)
                    {
                        cont++;
                        continue;
                    }
                }
                if((i==2 && j==0) || (i==0 && j==2))
                {
                    if(tab[i][j]==simb)
                    {
                        cont_2++;
                    }
                }
            }

            if(cont==3 || cont_2==3)
            {
                return true;
            }
        }

        return false;
    }
}
