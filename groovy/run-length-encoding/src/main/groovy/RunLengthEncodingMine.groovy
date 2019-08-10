class RunLengthEncodingMine implements RunLengthEncoding {
    private static String space = ' '

    static String dumpAccumulator(List<List<String>> accumulator) {
        accumulator
                .collect { it?.size() > 1 ? it?.size()?.toString() + it?.first() : it?.first()?.toString() }
                .join()
    }

    String encode(String input) {
        def toEncode = input.replaceAll(/[^a-zA-Z0-9${space}]/, '').toList()

        List accumulator = []
        List currentAccumulator = []
        while (toEncode) {
            def current = toEncode.pop()
            switch (currentAccumulator) {
                case { it.isEmpty() }:
                    currentAccumulator << current
                    break
                case { it.last() != current }:
                    accumulator << currentAccumulator
                    currentAccumulator = [current]
                    break
                default:
                    currentAccumulator << current
            }
        }
        if (currentAccumulator) {
            accumulator << currentAccumulator
        }
        dumpAccumulator(accumulator)
    }

    String decode(String input) {
        def toDecode = input.toList()

        List accumulator = []
        List counterAccumulator = []
        while (toDecode) {
            def current = toDecode.pop()
            switch (current) {
                case { it ==~ /[0-9]/ }:
                    counterAccumulator << current
                    break
                case { it ==~ /[a-zA-Z\s]/ && counterAccumulator.isEmpty() }:
                    accumulator << current
                    break
                default:
                    Integer counter = counterAccumulator.join().toInteger()
                    counterAccumulator = []
                    accumulator << current * counter
            }
        }
        accumulator.join()
    }
}