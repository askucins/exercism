class SecretHandshake {

    static handshakes = [
            ['wink', 0b1],
            ['double blink', 0b10],
            ['close your eyes', 0b100],
            ['jump', 0b1000]
    ]
    static int reverse = 0b10000
    static int mask = 0b11111

    static List<String> commands(int number) {
        number = number & mask
        List<String> result = handshakes.grep { (number & it[1]) }.collect { it[0] }
        if (number & reverse) {
            return result.reverse()
        } else {
            return result
        }
    }
}
