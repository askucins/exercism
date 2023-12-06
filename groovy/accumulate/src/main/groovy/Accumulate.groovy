class Accumulate {

    static accumulate(Collection collection, Closure func) {
        Collection result = []
        collection?.each {
            result << func(it)
        }
        result
    }
}