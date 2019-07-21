class NucleotideCount {

    static count(String strand) {
        def graph = ['A': 0, 'C': 0, 'G': 0, 'T': 0].withDefault {
            throw new ArithmeticException()
        }
        strand.toList().each { graph[(it)]++ }
        graph
    }
}