class RobotName {

    String name

    RobotName() {
        name = randomName()
    }

    def reset() {
        name = randomName()
    }

    static String randomName() {
        def letters = ('A'..'Z')
        def numbers = (0..9)
        def getRandomFrom = { List family ->
            Integer index = Math.floor(Math.random() * family.size()).toInteger()
            family[(index)]
        }
        String result = ''
        2.times { result += getRandomFrom(letters) }
        3.times { result += getRandomFrom(numbers) }
        result
    }
}
