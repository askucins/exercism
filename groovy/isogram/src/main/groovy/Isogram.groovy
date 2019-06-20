class Isogram {
    static boolean isIsogram(String phrase) {
        Set<String> uniqueTokens = []
        def result = true
        def tokens = phrase.toList()*.toLowerCase()
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

    // Some community starred solutions are based on comparing sizes of
    // - an array (a list) of letters
    // - and a set obtained by using .toSet() method on that list/array
    // or using the '.unique()' method
}
