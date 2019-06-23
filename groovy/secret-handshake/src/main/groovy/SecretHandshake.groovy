class SecretHandshake {

    static handshakes = [
            [0b1, 'wink'],
            [0b10, 'double blink'],
            [0b100, 'close your eyes'],
            [0b1000, 'jump']
    ]
    static int reverse = 0b10000

    static List<String> commands(int number) {
        List<String> handshake = handshakes
                .grep { (number & it[0]) }
                .collect { it[1].toString() }

        (number & reverse) ? handshake.reverse() : handshake
    }
}
