class RnaTranscription {

    def ofDNA(strand) {
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
}
