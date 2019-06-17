class Isogram {
    static boolean isIsogram(String phrase) {
        def tokens = phrase.toList()*.toLowerCase()
        Set<String> uniqueTokens = []
        def result = true
        while (tokens.size() > 0 && result) {
            def token = tokens.pop()
            if ([' ', '-'].contains(token)) {
                continue
            }
            if (uniqueTokens.contains(token)) {
                result = false
            } else {
                uniqueTokens.add(token)
            }
        }
        return result
    }

    // First approach, not that very nice
    static boolean initialVersion(String phrase) {
        def graph = [:]
        for (token in phrase) {
            if ([' ', '-'].contains(token)) {
                continue
            } else if (graph.containsKey(token.toLowerCase())) {
                return false
            } else {
                graph[(token.toLowerCase())] = 0
            }
        }
        return true
    }
}
