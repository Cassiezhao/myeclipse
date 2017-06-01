package com.cassie.think;

import java.math.BigInteger;

/**
 * Created by cassie on 2017/5/22.
 */
public class LargeFactorial {
    public static void main(String [] args){
        System.out.println(" 50! is \n " + factorial(50));
    }
    public static BigInteger factorial(long n){

        BigInteger result = BigInteger.ONE;
        for(int i = 1; i <= n; i++){
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }
}
