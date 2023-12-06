class DifferenceOfSquares {
    Integer num

    DifferenceOfSquares(num) {
        this.num = num
    }

    def squareOfSum() {
        def sum = (1..num).sum(0)
        //sum * sum
        sum.power(2)
    }

    def sumOfSquares() {
        //(1..num).collect { it * it }.sum(0)
        (1..num)*.power(2).sum(0)
    }

    def difference() {
        squareOfSum() - sumOfSquares()
    }

}
