

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, 
 * then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, 
 * the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class AmicableNumbers {
    public static void main(String[] args) {

        //Generate list with sum of divisors of each number
        List<Integer> myList = new ArrayList<Integer>();
        int limit = 10000;
        myList = genList(limit);
        
        //List for found amicable numbers
        List<Integer> results = new ArrayList<Integer>();
        int ami = 0;
        int amj = 0;

        //Loop to find amicable pairs
        for (int i = 2; i <= limit; i++) {
            ami = d(i, myList);
            if (ami < limit) {    
                amj = d(ami, myList);
                if (amj == i && ami != i) {
                    //System.out.println("Pairs: " + ami + " " + i);
                    //Add number to list.
                    results.add(i);
                }
            }
        }
        //Print list
        System.out.println("\nList of all amicable numbers: " + results);
        int sum = 0;

        //Calculate sum
        for (Integer integer : results) {
            sum += integer;
        }
        //Print sum
        System.out.println("Sum of amicable numbers in list = " + sum);
    } 



    static List<Integer> genList(int limit){

        List<Integer> divisors = new ArrayList<Integer>();
        divisors.add(0, 0);
        divisors.add(1, 1);
    
        for (int j = 2; j <= limit; j++) {
            int sum = 0;

            for (int i = 1; i < j; i++) {
                if (j % i == 0) {
                    sum += i;
                }
            }
            divisors.add(j, sum);
        }
        return divisors;
    }

    static int d(int index, List<Integer> myList){
        return myList.get(index);
    }
}


