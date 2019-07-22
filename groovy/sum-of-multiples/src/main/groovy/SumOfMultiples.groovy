class SumOfMultiples {

    static List<Integer> multiples(Integer factor, int limit) {
        (0..limit.intdiv(factor)).collect { factor * it }.grep { it < limit }
    }

    static Integer sum(List<Integer> factors, int limit) {
        def filteredFactors = factors.grep { it > 0 }.sort().unique()
        if (filteredFactors.size() < 1) {
            return 0
        } else {
            filteredFactors
                    .collect { multiples(it, limit) }
                    .flatten()
                    .sort()
                    .unique()
                    .sum(0)
                    .toInteger()
        }
    }
}