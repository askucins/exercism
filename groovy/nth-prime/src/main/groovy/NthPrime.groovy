import static org.apache.commons.math3.primes.Primes.nextPrime

// I am a stinky cheater and I will use org.apache.commons.math3.primes.Primes

class NthPrime {
    static List<Integer> primes = [2]

    static String status(String prefix) {
        "$prefix: size:${primes.size()}, last:${primes.last()}"
    }

    static nth(int n) {
        if (n < 1) {
            throw new ArithmeticException()
        }
        if (primes.size() >= n) {
            return primes[(n - 1)]
        }
        while (primes.size() < n) {
            primes.add(nextPrime(primes.last() + 1))
            println status('G')
        }
        primes.last()
    }
}