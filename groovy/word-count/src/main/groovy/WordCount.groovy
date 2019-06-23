class WordCount {
    String sentence
    private Map<String, Integer> graph = [:]

    WordCount(String s) {
        sentence = s.replaceAll(/\n+/, ' ') // Unwrap to one line with spaces as separators
        List<String> tokens = sentence.split(/\s+|,/) // split into pre-words
        List<String> words = tokens
                .collect { it.replaceAll(/^'|'$/, '') } // leading and trailing quotes are trimmed
                .collect { it.replaceAll(/[^a-zA-Z0-9']/, '').toLowerCase() } // normalize
                .collect { it.trim() } //  leading and trailing spaces are removed
                .grep { it } // finally all empty elements are removed
        words.each { String word ->
            graph.containsKey(word) ? graph[(word)]++ : graph.put(word, 1)
        }
    }

    def wordCount() {
        graph
    }
}