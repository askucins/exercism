class Acronym {

    static String abbreviate(String phrase) {
        //initialSolution(phrase)
        anotherSolution(phrase)
    }

    static String initialSolution(String phrase) {
        phrase
                .toLowerCase()
                .replaceAll(/'/, '') //apostrophes do not generate separate words
                .replaceAll(/[^a-z]/, ' ') // all other non-letters do
                .split(/\s+/)
                .collect { it[0] }
                .join()
                .toUpperCase()
    }

    static String anotherSolution(String phrase) {
        phrase
                .replaceAll(/['_]/, '') // apostrophes and underscores do not generate separate words
                .findAll(/(?i)\b[a-z]/) // case insensitive, no capture groups needed!
                .join()
                .toUpperCase()
    }
}