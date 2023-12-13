import groovy.transform.Memoized
import groovy.util.logging.Slf4j

@Slf4j
class PrimeFactors {

    static factors(value) {
        //factorsTrialDivisionBasic(value)
        factorsTrialDivisionWheel(value)
        //factorsTrialEratosthenesSieve(value) //This has some issues with big arrays :(
        //factorsByCommunityAmscotti(value)
    }

    // See: https://cp-algorithms.com/algebra/factorization.html#trial-division
    static List<Long> factorsTrialDivisionBasic(Long value) {
        Integer counter = 0
        List<Long> factorization = []
        for (Long d = 2; d * d <= value; d++) {
            log.info "[outside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization
            while (value % d == 0) {
                factorization.add(d)
                value /= d
                log.info "[inside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization

            }
        }
        if (value > 1) {
            factorization.add(value)
        }
        log.info "Total operations: {}", counter
        factorization
    }

    // See: https://cp-algorithms.com/algebra/factorization.html#wheel-factorization
    static List<Long> factorsTrialDivisionWheel(Long value) {
        Integer counter = 0
        List<Long> factorization = []
        while (value % 2 == 0) {
            factorization.add(2)
            value /= 2
            log.info "[even: {}] D: {}, V:{}, factorization: {}", counter++, 2, value, factorization
        }
        for (Long d = 3; d * d <= value; d += 2) {
            log.info "[outside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization
            while (value % d == 0) {
                factorization.add(d)
                value /= d
                log.info "[inside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization

            }
        }
        if (value > 1) {
            factorization.add(value)
        }
        log.info "Total operations: {}", counter
        factorization
    }

    //See: https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html
    @Memoized
    static List<Long> primes(Long n) {
        ArrayList<Boolean> isPrime = new ArrayList<Boolean>(n.toInteger()) //TODO This fails for large n!
        (0..n).each { isPrime[it] = true }
        isPrime[0] = false
        isPrime[1] = false
        for (Long i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (Long j = i * i; j <= n; j += i) {
                    isPrime[j] = false
                }
            }
        }
        (0..n).grep { isPrime[it] }
    }

    //See: https://cp-algorithms.com/algebra/factorization.html#precomputed-primes
    static List<Long> factorsTrialEratosthenesSieve(Long value) {
        Integer counter = 0
        List<Long> primes = primes(value)
        log.info "Primes: {}", primes
        List<Long> factorization = []
        for (Long d in primes) {
            log.info "[outside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization
            if (d * d > value) {
                break
            }
            while (value % d == 0) {
                factorization.add(d)
                value /= d
                log.info "[inside: {}] D: {}, V:{}, factorization: {}", counter++, d, value, factorization
            }
        }
        if (value > 1) {
            factorization.add(value)
        }
        log.info "Total operations: {}", counter
        factorization
    }

    //See: https://exercism.org/tracks/groovy/exercises/prime-factors/solutions/amscotti
    static List<Long> factorsByCommunityAmscotti(Long value) {
        List<Long> factors = []
        Long divisor = 2
        while (value > 1) {
            while (value % divisor == 0) {
                factors << divisor
                value /= divisor
            }
            divisor++
        }
        factors
    }
}
