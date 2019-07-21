class Proverb {

    static String lastSentence(String stuff) {
        "And all for the want of a $stuff."
    }

    static String runningSentence(String first, String second) {
        "For want of a $first the $second was lost.\n"
    }

    static String recite(List<String> strings) {
        //reciteMine(strings)
        reciteByCollate(strings)
    }

    // Based on community solution - that collate is awesome!
    static String reciteByCollate(List<String> strings) {
        strings.size()
                ?
                strings
                        .collate(2, 1, false)
                        .collect { runningSentence(it[0], it[1]) }
                        .join() + lastSentence(strings.first())
                : ''
    }

    static String reciteMine(List<String> strings) {
        String result = ''
        switch (strings.size()) {
            case 0:
                break
            case 1:
                result = lastSentence(strings.first())
                break
            default:
                (0..strings.size() - 2).each {
                    result += runningSentence(strings[(it)], strings[(it + 1)])
                }
                result += lastSentence(strings.first())
        }
        result
    }
}