class AtbashCipher {

    private static String alphabet = ('a'..'z').join()
    private static String reversed = alphabet.reverse()

    static String encode(String phrase) {
        phrase
                .toLowerCase()
                .replaceAll(/[^a-z0-9]/, '')
                .tr(alphabet, reversed)
                .toList()
                .collate(5, true)
                .collect { it.join() }
                .join(' ')
    }

    static String decode(String phrase) {
        phrase
                .replaceAll(/\s+/, '')
                .tr(reversed, alphabet)
    }

}