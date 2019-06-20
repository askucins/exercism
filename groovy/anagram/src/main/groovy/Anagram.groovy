class Anagram {
    private List letters

    Anagram(String subject) {
        letters = letterize(subject)
    }

    static List letterize(String subject) {
        subject.toLowerCase().toList().sort()
    }

    def find(candidates) {
        candidates.grep { String candidate -> letters == letterize(candidate) }
    }
}