class FlattenArray {

    static List<Integer> flattener(List array, List<Integer> accu) {
        if (array?.isEmpty()) {
            accu
        } else {
            def head = array?.head()
            List tail = array?.tail()
            if (head == null) {
                flattener(tail, accu)
            } else if (head instanceof Integer) {
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
        //flattenCommunity(array)
    }

    // Based on https://exercism.io/tracks/groovy/exercises/flatten-array/solutions/10109264748e4b44bf2bfc6a761cf636
    static flattenCommunity(input) {
        input.inject([]) { result, elem ->
            println "[B] result: $result, Elem: $elem"
            if (elem != null) {
                if (elem instanceof List) {
                    //flattenCommunity(elem).each { result << it }
                    result.addAll(flattenCommunity(elem))
                } else {
                    result << elem
                }
            }
            println "[A] result: $result, Elem: $elem"
            result
        }
    }
}

