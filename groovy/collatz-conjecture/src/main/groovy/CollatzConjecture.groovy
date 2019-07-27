class CollatzConjecture {

    static int steps(int number) {
        if (number < 1) {
            throw new ArithmeticException()
        }
        int stepsMade = 0
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2
            } else {
                number = number * 3 + 1
            }
            stepsMade++
        }
        stepsMade
    }
}