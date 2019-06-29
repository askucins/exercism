import groovy.util.logging.Slf4j

@Slf4j
class RobotName {
    private static Set names = []
    private static Random random = new Random()
    String name

    RobotName() {
        provisionName()
    }

    def reset() {
        provisionName()
    }

    def provisionName() {
        String newName = randomName()
        log.debug "Old name: $name, new name: $newName; Number of used names: ${names.size()}"
        if (names.contains(newName)) {
            throw new IllegalArgumentException("Name: $newName is already used!")
        } else {
            if (name) {
                names.remove(name)
            }
            names.add(newName)
            name = newName
        }
    }

    static String randomName() {
        def letters = ('A'..'Z')
        def numbers = (0..9)
        def getRandomFrom = { List family ->
            Integer index = random.nextInt(family.size())
            family[(index)]
        }
        String result = ''
        2.times { result += getRandomFrom(letters) }
        3.times { result += getRandomFrom(numbers) }
        result
    }
}
