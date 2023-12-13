class WordCount {
    private Map<String, Integer> graph = [:]

    WordCount(String s) {
        List<String> words = wordsMine(s)
        //List<String> words = wordsCommunity1(s)
        //List<String> words = wordsCommunity2(s)
        graph = words.countBy { it } // Nice! (Based on community solutions)
    }

    def countWords() {
        graph
    }

    static List<String> wordsMine(String sentence) {
        sentence
                .split(/[\s+,\n]+/) // split into pre-words
                .collect {
                    it
                            .replaceAll(/^'|'$/, '') // leading and trailing quotes are trimmed
                            .replaceAll(/[^a-zA-Z0-9']/, '') //removing trash
                            .toLowerCase() // normalize
                            .trim()  //  leading and trailing spaces are removed
                }.grep() // empty values are removed
    }

    static List<String> wordsCommunity1(String sentence) {
        sentence
                .toLowerCase()
                .findAll(/[a-z0-9]+('[a-z]+)?/)
    }

    static List<String> wordsCommunity2(String sentence) {
        sentence
                .toLowerCase()
                .replaceAll(/([^A-Za-z0-9']|\B'|'\B)/, ' ')
                .findAll(/[\w']+/)
    }

}