import spock.lang.*

@Stepwise
class NthPrimeSpec extends Specification {

    def setup() {
        println NthPrime.status('B')
    }

    def cleanup() {
        println NthPrime.status('A')
    }

    def "Can calculate a big prime first"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        10001  || 104743
    }

    def "Can calculate the first prime"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        1      || 2
    }

    def "Can calculate the second prime"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        2      || 3
    }

    def "Can calculate the sixth prime"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        6      || 13
    }

    def "Can calculate the seventh prime"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        7      || 17
    }

    def "Can calculate the sixth prime again"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        6      || 13
    }

    def "Can calculate a big prime"() {
        expect:
        NthPrime.nth(number) == expected

        where:
        number || expected
        10001  || 104743
    }

    def "Throws exception when asked for the zeroth prime"() {
        when:
        NthPrime.nth(0)

        then:
        thrown(ArithmeticException)
    }

}
