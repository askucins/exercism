class ArmstrongNumber {

    static isArmstrongNumber(Integer number) {
        def digits = number.toString().toList()*.toInteger()
        Integer numberLength = digits.size()
        number == digits.collect { Integer digit -> (digit**numberLength) }.sum(0)
    }

}