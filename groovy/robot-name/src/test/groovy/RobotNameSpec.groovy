import groovy.util.logging.Slf4j
import spock.lang.*

@Slf4j
class RobotNameSpec extends Specification {

    def "Generates a name"() {
        expect:
        new RobotName().name =~ /^[a-zA-Z]{2}\d{3}$/
    }

    def "Generates the same name when called again"() {
        given:
        def robot = new RobotName()

        expect:
        robot.name == robot.name
    }

    def "Different robots generate different names"() {
        given:
        def robot = new RobotName()
        def other_robot = new RobotName()

        expect:
        robot.name != other_robot.name
    }

    def "Can be reset to generate another name"() {
        given:
        def robot = new RobotName()
        def name_before_reset = robot.name
        robot.reset()
        def name_after_reset = robot.name

        expect:
        name_before_reset != name_after_reset
    }

    def "Can be reset multiple times"() {
        given:
        def robot = new RobotName()
        expect:
        100.times { assert robot.reset() }
    }

    // According to
    // https://math.stackexchange.com/questions/1610327/expected-number-of-draws-with-replacement-until-a-repeat-draw
    // the expected length of series of unique names is around 1030
    def "Can be given multiple times"() {
        given:
        def robots = []
        expect:
        100.times { assert robots.add(new RobotName()) }
    }

}
