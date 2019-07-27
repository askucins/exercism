class RotationalCipher {
    private static List<String> alphabet = ('a'..'z')
    private int key

    RotationalCipher(int key) {
        this.key = key
    }

    String rotate(String cipherText) {
        cipherText.toList().collect {
            def result = it
            def idx = alphabet.indexOf(it.toLowerCase())
            if (idx >= 0) {
                def position = (idx + key) % alphabet.size()
                String rotated = alphabet[(position)]
                result = it.toCharacter().lowerCase ? rotated : rotated.toUpperCase()
            }
            result
        }.join()
    }
}
