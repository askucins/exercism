class NucleotideCount {

    static count(String strand) {
        if (strand =~ /[^ACGT]/) {
            throw new ArithmeticException()
        }
        Map graph = ['A': 0, 'C': 0, 'G': 0, 'T': 0]
        strand.toList().each { graph[(it)]++ }
        graph
    }
}