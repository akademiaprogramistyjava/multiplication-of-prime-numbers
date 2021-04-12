package pl.szymonleyk;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("n: ");
//        int n = scanner.nextInt();
        int n = 6;
        String result = numPrimorial(n);

        System.out.println(result);
    }

    public static String numPrimorial(int n) {
        ArrayList<Integer> numbers = nPrimeNumbers(n);
        System.out.println(numbers);
        int[] result = {numbers.get(0)};
        for (int i = 1; i < numbers.size(); i++) {
            String second = String.valueOf(numbers.get(i));

            int[] a = result;
            int[] b = getIntArray(second);

            result = multiply(a, b);
        }

        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        String text = Arrays.toString(result);
        text = text.replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
        int i = 0;
        for (; i < text.length(); i++) {
            int value = Integer.parseInt(String.valueOf(text.charAt(i)));;
            if (value != 0) {
                break;
            }
        }
        text = text.substring(i);


        return text;
    }

    private static int[] getIntArray(String text) {
        int[] numbers = new int[text.length()];
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return numbers;
    }

    public static int[] multiply(int[] a, int[] b) {
        int[] product = new int[a.length + b.length];
        for (int i = 0; i < b.length; i++) {
            int carry = 0;
            for (int j = 0; j < a.length; j++) {
                int position = i + j;
                product[position] += carry + a[j] * b[i];
                carry = product[position] / 10;
                product[position] = product[position] % 10;
            }
            product[i + a.length] = carry;
        }
        return product;
    }

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
