class BinarySearch {
    private NOT_FOUND = -1
    List data

    // You may assume for this exercise that the input data is sorted in ascending order.
    BinarySearch(List data) {
        this.data = data
        assert data == data.sort()
    }

    int indexOf(item) {
        findValue(item, 0, data?.size() - 1)
    }

    Integer findValue(item, Integer left, Integer right) {
        if (left > right) {
            return NOT_FOUND
        } else {
            Integer half = (left + right).intdiv(2)
            if (item == data[(half)]) {
                return half
            }
            if (item < data[(half)]) {
                return findValue(item, left, half - 1)
            } else {
                return findValue(item, half + 1, right)
            }
        }

    }
}