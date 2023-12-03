import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses([
        SpecsFactory.RunEncMineSpec,
        SpecsFactory.RunEncByAmscottiSpec
])
class ExtendingClassesTestSuite {}
