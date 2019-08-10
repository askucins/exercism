import groovy.util.logging.Slf4j
import spock.lang.*

class RunLengthEncodingSpec extends Specification {

    RunLengthEncoding encoder() { null }

    @Shared
    RunLengthEncoding runLengthEncoder

    def setupSpec() {
        runLengthEncoder = encoder() ?: new RunLengthEncodingMine()
        println "Encoder: ${runLengthEncoder.class.toString()}"
    }

    @Unroll
    def "Run-length encode #string"() {
        expect:
        runLengthEncoder.encode(string) == expected

        where:
        string                                                  || expected
        ''                                                      || ''
        'XYZ'                                                   || 'XYZ'
        'AABBBCCCC'                                             || '2A3B4C'
        'WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB' || '12WB12W3B24WB'
        '  hsqq qww  '                                          || '2 hs2q q2w2 '
        'aabbbcccc'                                             || '2a3b4c'
        'aaAAA'                                                 || '2a3A'
        'aaa'                                                   || '3a'
        'a'                                                     || 'a'
        'a A'                                                   || 'a A'
        'a  A'                                                  || 'a2 A'
    }

    @Unroll
    def "Run-length decode #string"() {
        expect:
        runLengthEncoder.decode(string) == expected

        where:
        string          || expected
        ''              || ''
        'XYZ'           || 'XYZ'
        '2A3B4C'        || 'AABBBCCCC'
        '12WB12W3B24WB' || 'WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB'
        '2 hs2q q2w2 '  || '  hsqq qww  '
        '2a3b4c'        || 'aabbbcccc'
    }

    @Unroll
    def "Encode followed by decode gives original string (#string)"() {
        setup:
        RunLengthEncoding run = runLengthEncoder

        expect:
        run.decode(run.encode(string)) == expected

        where:
        string       || expected
        'zzz ZZ  zZ' || 'zzz ZZ  zZ'
        ''           || ''
        ' '          || ' '
        'a  A'       || 'a  A'
        'aaAAaa'     || 'aaAAaa'
    }
}