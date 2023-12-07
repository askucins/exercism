import groovy.json.JsonOutput
import groovy.util.logging.Slf4j

@Slf4j
class MatchingBrackets {

    // Inspired by https://raganwald.com/2018/10/17/recursive-pattern-matching.html
    static Boolean isBalanced(String left, String value, String right, String marker) {
        log.debug "[{}] L: \'{}\', V: \'{}\', R: \'{}\'", marker, left, value, right
        if (value == '') {
            return true
        }
        if (value.startsWith(left)) {
            // (BS1)BS2 - a loop over the occurrences of ')'
            Integer rightPosition = value.indexOf(right)
            while (rightPosition > 0) {
                log.debug "[{}] LS: \'{}\', RS: \'{}\'", marker, value.substring(1, rightPosition), value.substring(rightPosition + 1)
                if (isPairedMine(value.substring(1, rightPosition), marker) && isPairedMine(value.substring(rightPosition + 1), marker)) {
                    return true
                } else {
                    rightPosition = value.indexOf(right, rightPosition + 1)
                }
            }
        }
        return false
    }

    // Gotcha! An optimization to this repetition of calls
    // is that that clever map of brackets from the community solutions.
    // This approach is really un-optimal :(
    static isPairedMine(String value, String marker = 'init') {
        String onlyBrackets = value.replaceAll(/[^(){}\[\]]/, '')
        isBalanced('(', onlyBrackets, ')', marker + ':' + 'normal')
            || isBalanced('{', onlyBrackets, '}', marker + ':' + 'curly')
            || isBalanced('[', onlyBrackets, ']', marker + ':' + 'square')
    }

    /* ************************************************************************************************************** */

    // https://exercism.org/tracks/groovy/exercises/matching-brackets/solutions/db6e8d6b1b674508985f5fb00ee18407

    static final MAP = ['}': '{', ']': '[', ')': '(']

    static Boolean isPairedCommunityByAmscotti(String value) {
        List<String> clean = value.findAll { MAP.containsValue(it) || MAP.containsKey(it) }
        log.info "clean: {}", JsonOutput.toJson(clean)
        List<String> stack = []
        for (i in clean) {
            log.info "i:{} of clean: {}", i, JsonOutput.toJson(clean)
            if (MAP.containsValue(i)) {
                stack << i
                log.info "stack: {}", JsonOutput.toJson(stack)
            } else if (!stack.isEmpty() && MAP.get(i) == stack.last()) {
                log.info "Removed from stack: {}", stack.removeLast()
            } else {
                log.info "The other branch"
                return false
            }
        }
        log.info "Check if stack is empty: {}", stack.isEmpty()
        stack.isEmpty()
    }

    /* ************************************************************************************************************** */

    // https://exercism.org/tracks/groovy/exercises/matching-brackets/solutions/b04bb2b8fb954e68aaca0833d8a16204

    private static final BRACKETS = ['}': '{',
                                     ']': '[',
                                     ')': '(']

    static boolean isPairedCommunityKiril(String value) {
        value.findAll { BRACKETS.containsKey(it) || BRACKETS.containsValue(it) }
            .inject([]) { acc, i ->
                acc && BRACKETS.get(i) == acc.head() ? acc.tail() : [i, *acc]
            }.empty
    }

    /* ************************************************************************************************************** */

    static Boolean isPaired(String value) {
        isPairedMine(value)
        //isPairedCommunityByAmscotti(value)
        //isPairedCommunityKiril(value)
    }

}