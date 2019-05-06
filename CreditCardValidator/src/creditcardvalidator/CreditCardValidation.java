package creditcardvalidator;

import java.util.*;
public class CreditCardValidation
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter a credit card number as a long integer: ");
        long creditCard1 = input.nextLong();
        if(isValid(creditCard1))
        {
            System.out.println(creditCard1 + " is a valid credit card");
        }
        else
        {
            System.out.println(creditCard1 + " is not a valid credit card");
        }        
    }
    //return true if the card is valid
    public static boolean isValid(long number)
    {
        int n;
        long p;
        p = getPrefix(number, 1);
        if(p < 4)
        {
            return false;
        }
        n = getSize(number);
        if(n < 13 || n > 16)
        {
            return false;
        }
        if((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    //get the result from step 2
    public static int sumOfDoubleEvenPlace(long number)
    {
        int i = 0;
        int sum = 0;
        for(i = 1; i <= 16; i++)
        {
            if(i % 2 == 0)
            {
                sum = sum + getDigit((int)(number % 10) * 2);   
            }
            else
            {
                number /= 10;
            }  
        }
        return sum;
    }
    //return this number if it is a single digit, otherwise return the sum of the two digits
    public static int getDigit(int number)
    {
        if(number < 10)
        {
            return number;
        }
        else
        {
            return (number / 10) + (number % 10);
        }
    }
    //return sum of odd-place digits in number
    public static int sumOfOddPlace(long number)
    {
        int i = 0;
        int sum = 0;
        for(i = 1; i <= 16; i++)
        {
            if(i % 2 == 1)
            {
                sum = sum + (int)(number % 10);
            }
            else
            {
                number /= 10;
            }
        }
        return sum;
    }
    //return true if the digit d is a prefix for number
    public static boolean prefixMatched(long number, int d)
    {
        if(getPrefix(number, 1) == d || getPrefix(number, 2) == d)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //return the number of digits in d
    public static int getSize(long d)
    {
        int n = 0;
        while(d != 0)
        {
            n++;
            d /= 10;
        }
        return n;
    }
    //return the first k number of digits from number.  
    //if the number of digits in number is less than k, return number
    public static long getPrefix(long number, int k)
    {
        if(k == 1)
        {
            return number/1000000000000000L;
        }
        if(k == 2)
        {
            return number/1000000000000000L;
        }
        return 0;
    }
}