class AllYourBase {
    Integer inputBase
    List<Integer> digits
    Integer value

    AllYourBase(Integer inputBase, List<Integer> digits) {
        if (inputBase <= 1) {
            throw new ArithmeticException()
        }
        if (digits.any { it < 0 || it >= inputBase }) {
            throw new ArithmeticException()
        }
        this.inputBase = inputBase
        this.digits = digits
        this.value = polyEval(inputBase, digits.reverse(), 1, 0)
    }

    Integer polyEval(Integer base, List<Integer> coefficients, Integer factor, Integer accu) {
        if (coefficients.isEmpty()) {
            accu
        } else {
            polyEval(base, coefficients.tail(), factor * base, accu + coefficients.head() * factor)
        }
    }

    List<Integer> polyBuild(Integer base, Integer value, List<Integer> accu) {
        if (value == 0) {
            accu
        } else {
            accu << value % base
            polyBuild(base, value.intdiv(base), accu)
        }
    }

    List<Integer> rebase(Integer outputBase) {
        if (outputBase <= 1) {
            throw new ArithmeticException()
        }
        if (this.value == 0) {
            [0]
        } else {
            polyBuild(outputBase, this.value, []).reverse()
        }
    }
}