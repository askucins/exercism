import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([RunLengthEncodingSpec.class])
class RunLengthEncodingTestSuite {
    @BeforeClass
    static void "configure test"() {
        RunLengthEncodingSpec.metaClass.encoder = { ->
            //new RunLengthEncodingMine()
            new RunLengthEncodingByAmscotti()
        }
    }
}
