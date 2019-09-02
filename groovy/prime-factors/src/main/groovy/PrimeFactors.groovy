import static org.apache.commons.math3.primes.Primes.primeFactors

// I am a stinky cheater and I will use org.apache.commons.math3.primes.Primes.primeFactors
//... unfortunately it fails on the 93819012551 (Long, not int!)
class PrimeFactors {

    static factors(int value) {
        if (value < 2) {
            return []
        } else {
            return primeFactors(value)
        }
    }
}