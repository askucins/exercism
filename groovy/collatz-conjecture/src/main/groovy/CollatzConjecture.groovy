class CollatzConjecture {

    static int steps(int number) {
        int stepsMade = 0
        if (number < 1) {
            throw new ArithmeticException()
        }
        while (true) {
            if (number == 1) {
                break
            }
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