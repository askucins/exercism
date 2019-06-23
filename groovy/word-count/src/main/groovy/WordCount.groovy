class WordCount {
    String sentence
    private Map<String, Integer> graph = [:]

    WordCount(String s) {
        sentence = s.replaceAll(/[^a-zA-Z0-9\\']/, ' ').toLowerCase()
        List<String> words = sentence.split(/\s+/).grep { it }.collect { it.replaceAll(/^'|'$/, '') }
        words.each { String word ->
            graph.containsKey(word) ? graph[(word)]++ : graph.put(word, 1)
        }
    }

    def wordCount() {
        graph
    }
}