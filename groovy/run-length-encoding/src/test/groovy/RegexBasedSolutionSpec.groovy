import spock.lang.Specification
import spock.lang.Unroll

// Analysis of that Amscotti's solution approach
class RegexBasedSolutionSpec extends Specification {

    def "should encode work"() {
        expect:
        input.findAll(/(\D)\1+/) == parsed

        cleanup:
        println 'Encoded: ' + input.replaceAll(/(\D)\1+/) { group, letter ->
            println "$group:$letter"
            "${group.length()}${letter}"
        }

        where:
        input                 || parsed
        'aaAAbBBBcCCCCccdeEE' || ['aa', 'AA', 'BBB', 'CCCC', 'cc', 'EE']
    }

    def "should decode work"() {
        expect:
        input.findAll(/(\d+)(\D)/) == parsed

        cleanup:
        println 'Decoded: ' + input.replaceAll(/(\d+)(\D)/) { all, count, letter ->
            println "$all:$count:$letter"
            letter * (count as int)
        }

        where:
        input             || parsed
        '2a2A3Bc4C2cde2E' || ['2a', '2A', '3B', '4C', '2c', '2E']
    }
}