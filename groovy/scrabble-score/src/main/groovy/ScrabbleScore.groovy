class ScrabbleScore {

    static Integer weight(character) {
        Integer result
        switch (character.toUpperCase()) {
            case ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T']:
                result = 1; break
            case ['D', 'G']:
                result = 2; break
            case ['B', 'C', 'M', 'P']:
                result = 3; break
            case ['F', 'H', 'V', 'W', 'Y']:
                result = 4; break
            case ['K']:
                result = 5; break
            case ['J', 'X']:
                result = 8; break
            case ['Q', 'Z']:
                result = 10; break
            default:
                throw new IllegalArgumentException("This is not a character: $character")
        }
        result
    }

    static scoreWord(String word) {
        word.collect { weight(it) }.sum(0) // That initial zero handles the case of an empty word
    }

}
