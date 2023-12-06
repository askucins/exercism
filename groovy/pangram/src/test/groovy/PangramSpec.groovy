import spock.lang.*

class PangramSpec extends Specification {

    def "Sentence empty"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence || expected
        ''       || false
    }

    def "Recognizes a perfect lower case pangram"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                     || expected
        'abcdefghijklmnopqrstuvwxyz' || true
    }

    def "Pangram with only lower case"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the quick brown fox jumps over the lazy dog' || true
    }

    def "Missing character 'x'"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                                      || expected
        'a quick movement of the enemy will jeopardize five gunboats' || false
    }

    def "Another missing character, e.g. 'h'"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                 || expected
        'five boxing wizards jump quickly at it' || false
    }

    def "Pangram with underscores"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the_quick_brown_fox_jumps_over_the_lazy_dog' || true
    }

    def "Pangram with numbers"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                           || expected
        'the 1 quick brown fox jumps over the 2 lazy dogs' || true
    }

    def "Missing letters replaced by numbers"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        '7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog' || false
    }

    def "Pangram with mixed case and punctuation"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                   || expected
        '"Five quacking Zephyrs jolt my wax bed."' || true
    }

    def "Upper and lower case versions of the same character should not be counted separately"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the quick brown fox jumps over with lazy FX' || false
    }

}