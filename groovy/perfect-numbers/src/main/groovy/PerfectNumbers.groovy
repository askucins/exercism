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

    static Integer aliquotSum(Integer num) {
        List<Integer> factors = factorize(num)
        println "Factors of $num: $factors"
        factors.sum(0)
    }

    static List<Integer> factorize(Integer num) {
        (1..<num).grep { num % it == 0 }.toList()
    }

}