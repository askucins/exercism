class Isogram {
    static boolean isIsogram(String phrase) {
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
