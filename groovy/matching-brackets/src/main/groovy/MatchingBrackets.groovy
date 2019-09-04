class MatchingBrackets {

    //Inspired by http://raganwald.com/2018/10/17/recursive-pattern-matching.html
    static isPaired(String value) {
        String onlyBrackets = value.replaceAll(/[^(){}\[\]]/, '')
        isBalanced('(', onlyBrackets, ')') ||
                isBalanced('[', onlyBrackets, ']') ||
                isBalanced('{', onlyBrackets, '}')
    }

    static Boolean isBalanced(String left, String value, String right) {
        if (value == '') {
            return true
        }
        if (value.startsWith(left)) {
            // (BS1)BS2 - a loop over the occurrences of ')'
            Integer rightPosition = value.indexOf(right)
            while (rightPosition > 0) {
                if (isPaired(value.substring(1, rightPosition)) && isPaired(value.substring(rightPosition + 1))) {
                    return true
                } else {
                    rightPosition = value.indexOf(right, rightPosition + 1)
                }
            }
        }
        return false
    }
}