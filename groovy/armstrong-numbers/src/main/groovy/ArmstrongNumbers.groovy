class ArmstrongNumbers {

    static isArmstrongNumber(Integer number) {
        def digits = number.toString()*.toInteger()
        Integer numberLength = digits.size()
        number == digits.collect { Integer digit -> digit.power(numberLength) }.sum(0)
    }

}