import java.util.*;

public class Exercise2 {

    public static int add(int a, int b) {

        if(a > 0) {
            if(a > Integer.MAX_VALUE - b) {
                System.out.println("Addition Overflowed");
                return 0;
            }
        }

        return a + b;

    }



    public static void main(String [] args) {

        System.out.println("Please give a first number");
        Scanner src = new Scanner(System.in);
        int a = src.nextInt();
        System.out.println("Please give a second number");
        int b = src.nextInt();



        int add = add(a, b);
        System.out.println("Add: " + add);

        src.close();
    }

}