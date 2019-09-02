class FlattenArray {

    static List<Integer> flattener(List array, List<Integer> accu) {
        if (array?.isEmpty()) {
            accu
        } else {
            def head = array?.head()
            List tail = array?.tail()
            if (head == null) {
                flattener(tail, accu)
            } else if (head.toString().isInteger()) {
                flattener(tail, accu << head.toInteger())
            } else {
                accu.addAll(flattener(head as List, []))
                flattener(tail, accu)
            }
        }
    }

    static List<Integer> flatten(List array) {
        //array.flatten().grep { it != null }*.toInteger()
        flattener(array, [])
    }
}
