class Hamming {

    static distance(String strand1, String strand2) {
        if (strand1.size() != strand2.size()) {
            throw new ArithmeticException()
        }
        if (strand1.size() == 0) {
            return 0
        } else {
            // Mine
            //[strand1.collect(), strand2.collect()].transpose().collect { it[0] == it[1] ? 0 : 1 }.sum()
            // Based on community solution - it's better to count them!
            [strand1.collect(), strand2.collect()].transpose().count { st1, st2 -> st1 != st2 }
        }
    }
}