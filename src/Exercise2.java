package src;
import java.util.*;


public class Exercise2 {


    public static final int MAX_INT = 2147483647;
    public static final int MIN_INT = -2147483648;


    public static int add(int a, int b) {
        
        if(a > 0) {
            if(a > MAX_INT - b) {
                System.out.println("Addition Overflowed");
                return 0;
            }
        } else if (a < 0) {
            if (a < MIN_INT + b) {
                System.out.println("Addition Overflowed");
                return 0;
            }
        }

        return a + b;
    }


    public static int subtract(int a, int b) {
    
        if(a > 0) {
            if(a > MAX_INT + b) {
                System.out.println("Subtraction Overflowed");
                return 0;
            }
        } else if (a < 0) {
            if (a < MIN_INT - b) {
                System.out.println("Subtraction Overflowed");
                return 0;
            }
        }

        return a - b;
    }


    public static int multiply(int a, int b) {
       
        if(b > 0) {

            if(a > Integer.MAX_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }

            if(a < Integer.MIN_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }
        }

        if(a > 0){

            if(a < Integer.MIN_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }

        }

        if(a < 0) {
            if (a > Integer.MAX_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }
        }

        return a * b;
    }


    public static void main(String [] args) {
        /*
        System.out.println("Please give a first number");
        Scanner src = new Scanner(System.in);
        int a = src.nextInt();
        System.out.println("Please give a second number");
        int b = src.nextInt();
        */ 

        // Divide
        System.out.println(Double.valueOf(MIN_INT / MAX_INT));

        // Add
        System.out.println("Add: " + add(2, 2147483647)); // should overflow
        System.out.println("Add: " + add(-2, -2147483648)); // should overflow

        // subtract
        System.out.println("Subtract: " + subtract(-2, 2147483647)); // should overflow
        System.out.println("Subtract: " + subtract(2, -2147483648)); // should overflow

        // multiply
        System.out.println("Multiply: " + multiply(-2, 2147483647)); // should overflow
        System.out.println("Multiply: " + multiply(-2, 2147483647)); // should overflow


        // src.close();
    }

}