class ResistorColorTrio {

    static colors = [
        black : 0,
        brown : 1,
        red   : 2,
        orange: 3,
        yellow: 4,
        green : 5,
        blue  : 6,
        violet: 7,
        grey  : 8,
        white : 9,
    ]

    static String addMultiplier(String color) {
        '0' * colors[(color)]
    }

    static String addUnit(String resistance) {
        String kilo = '000'
        resistance.endsWith(kilo)
            ? resistance.dropRight(kilo.size()) + ' kiloohms'
            : resistance + ' ohms'
    }

    static String label(List<String> colorsInput) {
        String resistance = colorsInput[0..1]
            .collect { colors[(it)].toString() }
            .join() + addMultiplier(colorsInput[2])
        addUnit(resistance)
    }

    // With some extra control
//    static String label(List<String> colorsInput) {
//        String result = null
//        try {
//            String resistance = colorsInput[0..1]
//                .collect { colors[(it)].toString() }
//                .join() + addMultiplier(colorsInput[2])
//            result = addUnit(resistance)
//        } catch (e) {
//            throw new IllegalArgumentException("Probably invalid argument!", e)
//        }
//        result
//    }

}