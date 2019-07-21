class RomanNumerals {
    static romanCharacters = [
            'I', // 1
            'V', // 5
            'X', // 10
            'L', // 50
            'C', // 100
            'D', // 500
            'M', // 1000
    ].withDefault { '' }

    static String processDigit(Integer digit, List<String> romans) {
        String result
        switch (digit) {
            case [1, 2, 3]:
                result = romans[0] * digit
                break
            case 4:
                result = romans[0] + romans[1]
                break
            case 5:
                result = romans[1]
                break
            case [6, 7, 8]:
                result = romans[1] + romans[0] * (digit - 5)
                break
            case 9:
                result = romans[0] + romans[2]
                break
            default:
                result = ''
        }
        result
    }

    RomanNumerals() {
        Integer.metaClass.getRoman = { ->
            if (value < 1 || value > 3000) {
                throw new IllegalArgumentException("$value is no romanizable!")
            }

            "$value"
                    .toList()
                    .reverse()
                    *.toInteger()
                    .withIndex()
                    .collect { Integer digit, int idx ->
                        processDigit(digit, romanCharacters[(idx * 2)..(idx * 2 + 2)])
                    }
                    .reverse()
                    .join()

        }
    }
}
