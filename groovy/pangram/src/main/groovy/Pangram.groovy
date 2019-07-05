class Pangram {

    static boolean isPangram(String sentence) {
        def sentenceSummary = sentence.toLowerCase().replaceAll(/[^a-z]/, '').collect().sort().unique()
        ('a'..'z') == sentenceSummary
    }
}