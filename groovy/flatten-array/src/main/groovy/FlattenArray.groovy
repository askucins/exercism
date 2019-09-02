class FlattenArray {
    static List<Integer> flatten(List array) {
        array.flatten().grep { it != null }*.toInteger()
    }
}
