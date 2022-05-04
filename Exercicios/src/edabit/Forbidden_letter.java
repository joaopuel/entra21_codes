package edabit;

import java.util.Scanner;

public class Forbidden_letter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite: ");
        String word = sc.nextLine();

        System.out.println(word);
        System.out.println(word.trim());

     //  System.out.println(forbiddenLetter(new String[]{"abc", "def", "ghi"}, 'i'));
    }

    public static boolean forbiddenLetter(String[] palavras, char letraProibida){

        for(String word : palavras)
        {
            for(int i=0; i<word.length(); i++)
            {
                if(word.charAt(i)==letraProibida)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
