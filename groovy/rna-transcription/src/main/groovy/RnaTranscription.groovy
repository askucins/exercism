class RnaTranscription {

    def ofDNA(strand) {
        transcriptDnaToRna(strand)
    }

    def mineSolution(strand) {
        strand.collect { nucleotide ->
            def value = ''
            switch (nucleotide) {
                case 'G':
                    value = 'C'
                    break
                case 'C':
                    value = 'G'
                    break
                case 'T':
                    value = 'A'
                    break
                case 'A':
                    value = 'U'
                    break
                default:
                    throw new IllegalArgumentException()
            }
            value
        }.join()
    }

    // Based on community solution - that .withDefault is pretty awesome!
    def transcriptDnaToRna(String strand) {
        def d2r = ['G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'].withDefault { throw new IllegalArgumentException() }
        strand.collect { d2r[(it)] }.join()
    }

}
