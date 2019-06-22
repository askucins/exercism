class Leap {
    Integer year

    Leap(Integer year) {
        this.year = year
    }

    def isLeapYear() {
        boolean byFour = year % 4 == 0
        boolean byHundred = year % 100 == 0
        boolean byFourHundred = year % 400 == 0

        (byFour && !byHundred) || byFourHundred
    }

}
