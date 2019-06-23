class SecretHandshake {

    static handshakes = [
            [0b1, 'wink'],
            [0b10, 'double blink'],
            [0b100, 'close your eyes'],
            [0b1000, 'jump']
    ]
    static int reverse = 0b10000
    static int mask = 0b11111

    static List<String> commands(int number) {
        number = number & mask // We care only about 'handshake-like' numbers

        List<String> handshake = handshakes.grep { (number & it[0]) }.collect { it[1].toString() }

        (number & reverse) ? handshake.reverse() : handshake

    }
}
