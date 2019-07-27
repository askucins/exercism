import java.util.stream.IntStream

import static org.apache.commons.math3.primes.Primes.nextPrime

// I am a stinky cheater and I will use org.apache.commons.math3.primes.Primes.nextPrime

class NthPrime {
    static List<Integer> primes = [2]

    static String status(String prefix) {
        "$prefix: size:${primes.size()}, last:${primes.last()}"
    }

    static nth(int n) {
        nthMine(n)
        //nthCommunitySolution(n)
    }

    static nthMine(int n) {
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

    // And here a variant based on Kirill-Artamonov's solution
    // https://exercism.io/tracks/groovy/exercises/nth-prime/solutions/27da92d4ca624d09b7304e8a4eddb529
    // ... but apparently it requires JDK 9 (that .takeWhile())
    static nthCommunitySolution(int n) {
        if (n < 1)
            throw new ArithmeticException()

        Collection<Integer> primes = []
        IntStream.iterate(2, { it + 1 })
                .peek({ v ->
                    if (!primes.any { p -> v % p == 0 }) primes.add v
                }).takeWhile({ primes.size() < n })
                .collect()
        primes.last()
    }
}