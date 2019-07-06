import groovy.transform.Canonical

@Canonical
class HighScores {

    List<Integer> scores

    Integer latest() { scores.last() }

    Integer personalBest() { scores.max() }

    List<Integer> personalTopThree() {
        scores.sort { a, b -> b <=> a }.subList(0, Math.min(3, scores.size()))
    }

}