class RotationalCipher {
    private static List<String> alphabet = ('a'..'z')
    private static Integer alphabetSize = alphabet.size()
    private int key

    RotationalCipher(int key) {
        this.key = key
    }

    String rotate(String cipherText) {
        rotateMine(cipherText)
        //rotateCommunity(cipherText)
    }

    String rotateMine(String cipherText) {
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


    // Based on a community solution (glennj's)
    // https://exercism.io/tracks/groovy/exercises/rotational-cipher/solutions/3ac125a060834ec2862e040c7dfbb67a
    // This is to present the idea, the exact solution is smoother
    String rotateCommunity(String cipherText) {
        String alphabet = ('a'..'z').join()
        String rotated = alphabet.drop(key) + alphabet.take(key) //Brilliant!

        alphabet += alphabet.toUpperCase() //Brilliant again!
        rotated += rotated.toUpperCase()

        cipherText.tr(alphabet, rotated)
    }
}
