import spock.lang.*

class RnaTranscriptionSpec extends Specification {

    @Shared
    def complement = new RnaTranscription()

    def "The RNA complement of cytosine is guanine"() {
        expect:
        complement.ofDNA(dna) == expected

        where:
        dna || expected
        'C' || 'G'
    }

    def "The RNA complement of guanine is cytosine"() {
        expect:
        complement.ofDNA(dna) == expected

        where:
        dna || expected
        'G' || 'C'
    }

    def "The RNA complement of thymine is adenine"() {
        expect:
        complement.ofDNA(dna) == expected

        where:
        dna || expected
        'T' || 'A'
    }

    def "The RNA complement of adenine is uracil"() {
        expect:
        complement.ofDNA(dna) == expected

        where:
        dna || expected
        'A' || 'U'
    }

    def "Can calculate long strand complement"() {
        expect:
        complement.ofDNA(dna) == expected

        where:
        dna            || expected
        'ACGTGGTCTTAA' || 'UGCACCAGAAUU'
    }

    def "Correctly handles invalid input"() {
        when:
        complement.ofDNA('U')

        then:
        thrown(IllegalArgumentException)
    }

    def "Correctly handles completely invalid input"() {
        when:
        complement.ofDNA('XXX')

        then:
        thrown(IllegalArgumentException)
    }

    def "Correctly handles partially invalid input"() {
        when:
        complement.ofDNA('ACGTXXXCTTAA')

        then:
        thrown(IllegalArgumentException)
    }
}
