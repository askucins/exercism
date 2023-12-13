class HighScores {

    List<Integer> scores

    Integer latest() { scores.last() }

    Integer personalBest() { scores.max() }

    List<Integer> personalTopThree() {
        //scores.sort { a, b -> b <=> a }.subList(0, Math.min(3, scores.size()))
        // Based on community solutions
        //Gotcha! Only Lists are sorted in place (and we don't want to change the `scores`!)
        scores.toArray().sort().reverse().take(3)
    }

    HighScores(List scores) {
        this.scores = scores
    }

}