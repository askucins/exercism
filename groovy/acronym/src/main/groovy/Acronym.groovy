class Acronym {

    static String abbreviate(String phrase) {
        initialSolution(phrase)
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
}