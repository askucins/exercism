class PerfectNumbers {

    static Classification classify(Integer num) {
        if (num < 1) {
            throw new ArithmeticException()
        }

        def classification = aliquotSum(num) - num
        switch (classification) {
            case { it == 0 }:
                return Classification.PERFECT
            case { it > 0 }:
                return Classification.ABUNDANT
            case { it < 0 }:
                return Classification.DEFICIENT
            default:
                throw new ArithmeticException()
        }
    }

    // The aliquot sum is defined as the sum of the factors of a number not including the number itself.
    static Integer aliquotSum(Integer num) {
        if (num == 1) {
            return 0 // special case
        } else {
            List<Integer> factors = (1..(num.intdiv(2))).findAll { num % it == 0 }
            return factors.sum() as int
        }
    }
}