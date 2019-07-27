class RotationalCipher {
    private static List<String> alphabet = ('a'..'z')
    private static Integer alphabetSize = alphabet.size()
    private int key

    RotationalCipher(int key) {
        this.key = key
    }

    String rotate(String cipherText) {
        cipherText.toList().collect {
            def result = it
            def idx = alphabet.indexOf(it.toLowerCase())
            if (idx >= 0) {
                String rotated = alphabet[(idx + key) % alphabetSize]
                result = it.toCharacter().lowerCase ? rotated : rotated.toUpperCase()
            }
            result
        }.join()
    }
}
