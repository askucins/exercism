import spock.lang.*

class PerfectNumbersSpec extends Specification {

    @Unroll("#number should be a Perfect number")
    def "Perfect numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        6        || Classification.PERFECT
        28       || Classification.PERFECT
        33550336 || Classification.PERFECT
    }

    @Unroll("#number should be a Abundant number")
    def "Abundant numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        12       || Classification.ABUNDANT
        30       || Classification.ABUNDANT
        33550335 || Classification.ABUNDANT
    }

    @Unroll("#number should be a Deficient number")
    def "Deficient numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        2        || Classification.DEFICIENT
        4        || Classification.DEFICIENT
        32       || Classification.DEFICIENT
        33550337 || Classification.DEFICIENT
    }

    def "Edge case (no factors other than itself) is classified correctly"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number || expected
        1      || Classification.DEFICIENT
    }

    def "Zero is rejected (not a natural number)"() {
        when:
        PerfectNumbers.classify(0)

        then:
        thrown(ArithmeticException)
    }

    def "Negative integer is rejected (not a natural number)"() {
        when:
        PerfectNumbers.classify(-1)

        then:
        thrown(ArithmeticException)
    }

    @Unroll
    def "Should work in case of (#number) too"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number || expected
        1      || Classification.DEFICIENT
        2      || Classification.DEFICIENT
        3      || Classification.DEFICIENT
        4      || Classification.DEFICIENT
        5      || Classification.DEFICIENT
        6      || Classification.PERFECT
        7      || Classification.DEFICIENT
        8      || Classification.DEFICIENT
        9      || Classification.DEFICIENT
        10     || Classification.DEFICIENT
        11     || Classification.DEFICIENT
        12     || Classification.ABUNDANT
    }
}