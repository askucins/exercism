class RobotName {
    private static Random random = new Random()
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
            Integer index = random.nextInt(family.size())
            family[(index)]
        }
        String result = ''
        2.times { result += getRandomFrom(letters) }
        3.times { result += getRandomFrom(numbers) }
        result
    }
}
