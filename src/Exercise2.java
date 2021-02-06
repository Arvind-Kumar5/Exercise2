/**
 * This is Exercise 2 on Numeric Errors.
 * The code checks for integer overflow for + - * /
 * 
 * @author Dylan Melotik / dmelotik@wisc.edu
 * @author Arvind Kumar / askumar3@wisc.edu
 */

package src;

public class Exercise2 {

    /**
     * Adds integer a and b and catches any overflow errors
     * 
     * @param a -first integer
     * @param b -second integer
     * @return a + b, 0 if overflow was detected
     */
    public static int add(int a, int b) {
        if (b > 0) { // check for overflow
            if (a > Integer.MAX_VALUE - b) {
                System.out.println("Addition Overflowed");
                return 0;
            }
        } else if (b < 0) { // catches underflow
            if (a < Integer.MIN_VALUE - b) {
                System.out.println("Addition Overflowed");
                return 0;
            }
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
        if (b > 0) { // catches underflow
            if (a < Integer.MIN_VALUE + b) {
                System.out.println("Subtraction Overflowed");
                return 0;
            }
        } else if (b < 0) { // catching overflow
            if (a > Integer.MAX_VALUE + b) {
                System.out.println("Subtraction Overflowed");
                return 0;
            }
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
        if(b > 0) { 

            if(a > Integer.MAX_VALUE/b) { // check for overflow
                System.out.println("Multiplication Overflowed");
                return 0;
            }

            if(a < Integer.MIN_VALUE/b) { // checking for underflow
                System.out.println("Multiplication Overflowed");
                return 0;
            }
        }
        
        // checking double negative, b=-1 would cause an overflow in the check
        if(b < -1 && a < 0){
            if (a < Integer.MAX_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }
        }

        // checking for underflow
        if(b < -1 && a > 0) {
            if(a > Integer.MIN_VALUE/b) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }
        }

        // edge case when b=-1 and a is the minimum, sign flips and causes overflow
        if(b == -1) {
            if(a == Integer.MIN_VALUE) {
                System.out.println("Multiplication Overflowed");
                return 0;
            }
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
        System.out.println("Add: " + add(Integer.MAX_VALUE, 1)); 
        System.out.println("Add: " + add(Integer.MIN_VALUE, -1));
        System.out.println("Add: " + add(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println("Add: " + add(Integer.MIN_VALUE, Integer.MAX_VALUE)); // should pass
        System.out.println("Add: " + add(Integer.MAX_VALUE, Integer.MIN_VALUE)); // should pass
        System.out.println("Add: " + add(1, Integer.MAX_VALUE));
        System.out.println("Add: " + add(-1, Integer.MIN_VALUE));
        System.out.println("Add: " + add(100, 100) + "\n"); // should pass

        // test subtract(a,b) all should cause overflow
        System.out.println("subtract: " + subtract(Integer.MAX_VALUE, 1)); // should pass
        System.out.println("subtract: " + subtract(Integer.MIN_VALUE, -1)); // should pass
        System.out.println("subtract: " + subtract(Integer.MAX_VALUE, -1));
        System.out.println("subtract: " + subtract(Integer.MIN_VALUE, 1));
        System.out.println("subtract: " + subtract(Integer.MIN_VALUE, Integer.MIN_VALUE)); // should pass
        System.out.println("subtract: " + subtract(Integer.MIN_VALUE, Integer.MAX_VALUE)); 
        System.out.println("subtract: " + subtract(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println("subtract: " + subtract(1, Integer.MAX_VALUE)); //should pass
        System.out.println("subtract: " + subtract(-1, Integer.MIN_VALUE));  // should pass
        System.out.println("subtract: " + subtract(-1, Integer.MAX_VALUE)); // should pass
        System.out.println("subtract: " + subtract(0, Integer.MIN_VALUE)); // 
        System.out.println("subtract: " + subtract(100, 100) + "\n"); // should pass

        // test multiply(a,b) all should cause overflow
        System.out.println("Multiply: " + multiply(2, 2147483647)); 
        System.out.println("Multiply: " + multiply(-2, 2147483647));
        System.out.println("Multiply: " + multiply(-2, -2147483648));
        System.out.println("Multiply: " + multiply(2, -2147483648)); 
        System.out.println("Multiply: " + multiply(100, 100)); // should pass
        System.out.println("Multiply: " + multiply(100, -100)); // should pass
        System.out.println("Multiply: " + multiply(-100, 100)); // should pass
        System.out.println("Multiply: " + multiply(-100, -100)); // should pass
        System.out.println("Multiply: " + multiply(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println("Multiply: " + multiply(Integer.MAX_VALUE, Integer.MIN_VALUE)); 
        System.out.println("Multiply: " + multiply(Integer.MAX_VALUE, -1)); // should pass
        System.out.println("Multiply: " + multiply(100, -1)); // should pass
        System.out.println("Multiply: " + multiply(Integer.MIN_VALUE, -1));
        System.out.println("Multiply: " + multiply(Integer.MAX_VALUE, 1)); // should pass
        System.out.println("Multiply: " + multiply(Integer.MIN_VALUE, 1) + "\n"); // should pass 


        // test divide(a,b) all should cause overflow
        System.out.println("Divide: " + divide(-2147483648, -1));
        System.out.println("Divide: " + divide(1000, 12)); // should pass

    }

}