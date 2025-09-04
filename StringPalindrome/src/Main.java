import java.util.Scanner;

import static java.util.Collections.reverse;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str1 = sc.nextLine();
        //StringBuffer sb = new StringBuffer(str1).reverse();
        //sb.reverse();
        String str2 = String.valueOf(new StringBuffer(str1).reverse());
        if(str1.equals(str2)) {
            System.out.println("Palindrome String");
        }
        else {
            System.out.println("Not a Palindrome");
        }
    }
}