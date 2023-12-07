class Grains {
    static square(num) {
        if (num < 1 || num > 64) {
            throw new ArithmeticException()
        }
        2**(num - 1)
    }

    static total() {
        2**64 - 1
    }
}
