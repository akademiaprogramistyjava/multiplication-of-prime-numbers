package pl.szymonleyk;

import java.util.ArrayList;

public final class Generate {
    public static ArrayList nPrimeNumbers(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        int i = 2;
        do {
            if(isPrime(i)){
                primes.add(i);
            }
            i++;
        } while (primes.size() < n);

        return primes;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
