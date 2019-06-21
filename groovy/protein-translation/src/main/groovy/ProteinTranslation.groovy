class ProteinTranslation {

    static STOP = 'STOP'
    enum AminoAcid {
        Methionine,
        Phenylalanine,
        Leucine,
        Serine,
        Tyrosine,
        Cysteine,
        Tryptophan,
        // Control sequence
        STOP
    }

    static translate = [
            AUG: AminoAcid.Methionine,
            UUU: AminoAcid.Phenylalanine,
            UUC: AminoAcid.Phenylalanine,
            UUA: AminoAcid.Leucine,
            UUG: AminoAcid.Leucine,
            UCU: AminoAcid.Serine,
            UCC: AminoAcid.Serine,
            UCA: AminoAcid.Serine,
            UCG: AminoAcid.Serine,
            UAU: AminoAcid.Tyrosine,
            UAC: AminoAcid.Tyrosine,
            UGU: AminoAcid.Cysteine,
            UGC: AminoAcid.Cysteine,
            UGG: AminoAcid.Tryptophan,
            UAA: AminoAcid.STOP,
            UAG: AminoAcid.STOP,
            UGA: AminoAcid.STOP
    ]

    static proteins(String strand) {
        def result = []
        boolean continueTranslation = true
        while (strand && continueTranslation) {
            def codon = strand.substring(0, 3)
            assert codon.size() == 3: 'Missing nucleotides!'
            def translation = translate[(codon)].toString()
            assert translation: 'Not recognized codon!'
            if (translation == AminoAcid.STOP.toString()) {
                continueTranslation = false
            } else {
                result.add translation
                strand = strand.substring(3)
            }
        }
        result
    }
}