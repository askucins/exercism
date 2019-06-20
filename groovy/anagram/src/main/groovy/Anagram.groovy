class Anagram {
    String subject
    private List letters

    Anagram(String subject) {
        this.subject = subject
        letters = letterize(subject)
    }

    static List letterize(String subject) {
        subject.toLowerCase().toList().sort()
    }

    def find(candidates) {
        candidates.grep { String candidate ->
            // a word itself is not its own anagram...
            subject.toLowerCase() != candidate.toLowerCase() &&
                    letters == letterize(candidate)
        }
    }
}