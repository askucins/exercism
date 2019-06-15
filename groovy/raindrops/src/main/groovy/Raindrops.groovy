class Raindrops {

    def divisors = [
            [3, 'Pling'],
            [5, 'Plang'],
            [7, 'Plong']
    ]

    def convert(num) {
        def result = ''
        divisors.each {
            if (num % it[0] == 0) {
                result += it[1]
            }
        }
        return result == '' ? num.toString() : result
    }

}
