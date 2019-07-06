class Proverb {

    static String lastSentence(String stuff) {
        "And all for the want of a $stuff."
    }

    static String runningSentence(String first, String second) {
        "For want of a $first the $second was lost.\n"
    }


    static String reciteHelper(List<String> strings, String accu) {
        switch (strings.size()) {
            case 1:
                return accu
            default:
                String first = strings.pop()
                String second = strings.first()
                return reciteHelper(strings, accu + runningSentence(first, second))
        }
    }

    static String recite(List<String> strings) {
        String result = ''
        if (strings.size()) {
            String lastSentence = lastSentence(strings.first())
            result = reciteHelper(strings, '') + lastSentence
        }
        result
    }
}