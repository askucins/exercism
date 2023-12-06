class ProteinTranslation {

    enum Protein {
        Methionine,
        Phenylalanine,
        Leucine,
        Serine,
        Tyrosine,
        Cysteine,
        Tryptophan,
        STOP // Control sequence
    }

    static Protein translate(String codon) throws IllegalArgumentException {
        def protein
        switch (codon) {
            case 'AUG':
                protein = Protein.Methionine
                break
            case ['UUU', 'UUC']:
                protein = Protein.Phenylalanine
                break
            case ['UUA', 'UUG']:
                protein = Protein.Leucine
                break
            case ['UCU', 'UCC', 'UCA', 'UCG']:
                protein = Protein.Serine
                break
            case ['UAU', 'UAC']:
                protein = Protein.Tyrosine
                break
            case ['UGU', 'UGC']:
                protein = Protein.Cysteine
                break
            case 'UGG':
                protein = Protein.Tryptophan
                break
            case ['UAA', 'UAG', 'UGA']:
                protein = Protein.STOP
                break
            default:
                throw new IllegalArgumentException("No match for codon: $codon")
        }
        protein
    }

    static String readCodon(String strand) throws IndexOutOfBoundsException {
        strand.substring(0, 3)
    }

    static String advanceStrand(String strand) throws IndexOutOfBoundsException {
        strand.substring(3)
    }

    static proteinsMine(String strand) {
        def result = []
        boolean continueTranslation = true
        while (strand && continueTranslation) {
            def codon = readCodon(strand)
            def protein = translate(codon)
            if (protein == Protein.STOP) {
                continueTranslation = false
            } else {
                result.add protein.toString()
                strand = advanceStrand(strand)
            }
        }
        result
    }

    static proteinsByCommunity(String strand) {
        strand
                .collect() // string to a list of characters
                .collate(3) // list of characters to a list of 3-elements lists
                .collect { it.join() } // list of 3-elements lists to list of 3-characters strings (codons)
                .collect { translate(it) } // codon to protein
                .takeWhile { it != Protein.STOP } // cut on the first STOP
                *.toString() // enum to string
    }

    static proteins(String strand) {
        proteinsByCommunity(strand)
    }
}