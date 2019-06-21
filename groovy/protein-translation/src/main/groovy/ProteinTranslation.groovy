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

    static Protein translate(String codon) {
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

    static String readCodon(String strand) {
        def codon = strand.substring(0, 3)
        assert codon.size() == 3: 'Missing nucleotides!'
        codon
    }

    static String advanceStrand(String strand) {
        strand.substring(3)
    }

    static proteins(String strand) {
        def result = []
        boolean continueTranslation = true
        while (strand && continueTranslation) {
            def codon = readCodon(strand)
            def protein = translate(codon)
            assert protein: 'Not recognized codon!'
            if (protein == Protein.STOP) {
                continueTranslation = false
            } else {
                result.add protein.toString()
                strand = advanceStrand(strand)
            }
        }
        result
    }
}