class PrimeFactors {

    static factors(value) {
        factorsTrialDivisionWheel(value)
    }

    // See: https://cp-algorithms.com/algebra/factorization.html#wheel-factorization
    static List<Integer> factorsTrialDivisionWheel(Long value) {
        List<Integer> factorization = []
        while (value % 2 == 0) {
            factorization.add(2)
            value /= 2
        }
        for (Integer d = 3; d * d <= value; d += 2) {
            while (value % d == 0) {
                factorization.add(d)
                value /= d
            }
        }
        if (value > 1) {
            factorization.add(value)
        }
        factorization
    }
}