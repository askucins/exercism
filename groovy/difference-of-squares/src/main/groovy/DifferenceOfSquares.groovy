class DifferenceOfSquares {
    Integer num

    DifferenceOfSquares(num) {
        this.num = num
    }

    def squareOfSum() {
        def sum = (1..num).sum(0)
        sum * sum
    }

    def sumOfSquares() {
        (1..num).collect { it * it }.sum(0)
    }

    def difference() {
        squareOfSum() - sumOfSquares()
    }

}
