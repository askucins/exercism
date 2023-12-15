class ArmstrongNumber {

    static isArmstrongNumber(Integer number) {
        //Gotcha! 'toList()' converts the given CharSequence into a List of Strings of one character.
        def digits = number.toString().toList()*.toInteger()
        Integer numberLength = digits.size()
        number == digits.collect { Integer digit -> (digit**numberLength) }.sum(0)
    }

}