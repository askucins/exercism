class Pangram {

    static boolean isPangram(String sentence) {
        //def sentenceSummary = sentence.toLowerCase().replaceAll(/[^a-z]/, '').collect().sort().unique()
        // Based on community solutions:
        def sentenceSummary = sentence.toLowerCase().replaceAll(/[^a-z]/, '').collect()
        ('a'..'z') as Set == sentenceSummary as Set
    }
}