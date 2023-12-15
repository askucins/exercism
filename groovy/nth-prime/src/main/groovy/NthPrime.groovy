class NthPrime {

    //See: https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html
    private static List<Integer> primesPrecomputedSmallerThan(Integer n) {
        println "Precomputing primes smaller than: $n"
        ArrayList<Boolean> isPrime = new ArrayList<Boolean>(n)
        (0..n).each { isPrime[it] = true }
        isPrime[0] = false
        isPrime[1] = false
        for (Integer i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (Integer j = i * i; j <= n; j += i) {
                    isPrime[j] = false
                }
            }
        }
        (0..n).grep { isPrime[it] }
    }

    // Approximation of the upper limit based on community solution
    // See: https://exercism.org/tracks/groovy/exercises/nth-prime/solutions/glennj
    // See: https://exercism.io/tracks/python/exercises/nth-prime/solutions/2a84e7330fab4b4cb04d92cf0f38164d
    // See: https://en.wikipedia.org/wiki/Prime_number_theorem

    private static int approximateNthPrime(int n) {
        2 + Math.floor(1.2 * n * Math.log(n))
    }

    private static Integer defaultPrecomputedLimit = 1000

    private static List<Integer> primes = primesPrecomputedSmallerThan(defaultPrecomputedLimit)

    static nth(int n) {
        if (n < 1) {
            throw new ArithmeticException()
        } else if (n > defaultPrecomputedLimit) {
            primes = primesPrecomputedSmallerThan(approximateNthPrime(n) * 2) //Gotcha! with small overhead
        }
        primes[n - 1]
    }
}