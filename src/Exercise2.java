/**
 * This is Exercise 2 on Numeric Errors.
 * The code checks for integer overflow for + - * /
 * 
 * @author Dylan Melotik / dmelotik@wisc.edu
 * @author Arvind Kumar / askumar3@wisc.edu
 */

package src;

public class Exercise2 {

    public static final int MAX_INT = 2147483647;
    public static final int MIN_INT = -2147483648;

    /**
     * Adds integer a and b and catches any overflow errors
     * 
     * @param a -first integer
     * @param b -second integer
     * @return a + b, 0 if overflow was detected
     */
    public static int add(int a, int b) {
        if (a > MAX_INT - b) { // checking if a + b goes past int max
            System.out.println("Addition Overflowed");
            return 0;
        }
        if (a < MIN_INT + b) { // checking if a + b goes past int min
            System.out.println("Addition Overflowed");
            return 0;
        }

        return a + b;
    }

    /**
     * Subtracts integers a and b and catches any overflow
     * 
     * @param a -first integer
     * @param b -second integer
     * @return a - b, 0 if overflow was detected
     */
    public static int subtract(int a, int b) {
        if (a < MIN_INT - b) { // checking if a - b goes past the integer min
            System.out.println("Subtraction Overflowed");
            return 0;
        }
        if (a > Integer.MAX_VALUE - b) { // checking if a - b goes past the integer max
            System.out.println("Subtraction Overflowed");
            return 0;
        }

        return a - b;
    }

    /**
     * Multiplies integer a and b, and checks for overflow
     * 
     * @param a -first integer
     * @param b -second integer
     * @return a * b, 0 if overflow was detected
     */
    public static int multiply(int a, int b) {
        if (a < Integer.MAX_VALUE/b) { // checking if a*b goes past the max int
            System.out.println("Multiplication Overflowed");
            return 0;
        }
        if (a > Integer.MIN_VALUE/b) { // checking if a*b goes past the min int
            System.out.println("Multiplication Overflowed");
            return 0;
        } 

        return a * b;
    }

    /**
     * Divides a and b, and checks for overflow
     * 
     * @param a -numerator
     * @param b -denomenator
     * @return a/b, 0 if overflow is detected
     */
    public static int divide(int a, int b) {
        // overflow past the max value if dividing the min by -1
        if(a <= Integer.MIN_VALUE && b == -1) {
            System.out.println("Divide Overflow");
            return 0;
        }

        return a/b;
    }


    public static void main(String [] args) {
    
        // test add(a,b) all should cause overflow
        System.out.println("Add: " + add(2, 2147483647)); 
        System.out.println("Add: " + add(-2, -2147483648));

        // test subtract(a,b) all should cause overflow
        System.out.println("Subtract: " + subtract(-2, 2147483647)); 
        System.out.println("Subtract: " + subtract(2, -2147483648)); 

        // test multiply(a,b) all should cause overflow
        System.out.println("Multiply: " + multiply(2, 2147483647)); 
        System.out.println("Multiply: " + multiply(-2, 2147483647));
        System.out.println("Multiply: " + multiply(-2, -2147483648));
        System.out.println("Multiply: " + multiply(2, -2147483648)); 

        // test divide(a,b) all should cause overflow
        System.out.println("Divide: " + divide(-2147483648, -1)); 

    }

}