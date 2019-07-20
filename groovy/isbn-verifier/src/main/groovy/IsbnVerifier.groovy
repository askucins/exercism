class IsbnVerifier {
    static boolean isValid(String isbn) {
        def tokens = isbn.replaceAll('-', '')

        if (tokens.size() != 10) {
            return false // ISBN has to have 10 characters
        }
        if (tokens =~ /[^X0-9]/) {
            return false //only digits and X
        }
        if (tokens[0..-2].contains('X')) {
            return false //X only allowed on the last position
        }

        def digits = tokens.collect { it == 'X' ? 10 : it.toInteger() }
        [digits, 10..1].transpose().collect { it[0] * it[1] }.sum(0) % 11 == 0
    }
}