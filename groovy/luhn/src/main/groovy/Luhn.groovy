class Luhn {

    static boolean valid(String value) {
        def tokens = value.replaceAll(/\s/, '')
        if (tokens.size() < 2) {
            return false // Input string must have at least two digits
        }
        if (tokens =~ /[^0-9]/) {
            return false // Only digits are allowed
        }
        tokens
                .reverse()
                .collect { it.toInteger() }
                .withIndex() //awesome feature!
                .collect { Integer entry, int idx ->
                    if (idx % 2 == 0) {
                        entry
                    } else {
                        def doubled = entry * 2
                        doubled > 9 ? doubled - 9 : doubled
                    }

                }
                .sum(0) % 10 == 0
    }
}
