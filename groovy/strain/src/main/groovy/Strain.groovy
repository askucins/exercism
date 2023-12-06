class Strain {

    static Collection keep(Collection collection, Closure predicate) {
        Collection result = []
        collection?.each {
            if (predicate(it)) {
                result << it
            }
        }
        result
    }

    static Collection discard(Collection collection, Closure predicate) {
        keep(collection, { !predicate(it) })
    }

}