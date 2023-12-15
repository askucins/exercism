class ResistorColorDuo {

    static colors = [
        black : '0',
        brown : '1',
        red   : '2',
        orange: '3',
        yellow: '4',
        green : '5',
        blue  : '6',
        violet: '7',
        grey  : '8',
        white : '9',
    ]

    static int value(List<String> colorsInput) {
        colorsInput.collect { colors[(it)] }.take(2).join().toInteger()
    }
}