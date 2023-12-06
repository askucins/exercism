class DoubleLinkedList<T> {
    Node<T> first = null
    Node<T> last = null

    Boolean isEmpty() {
        first == null && last == null
    }

    class Node<T> {
        T value
        Node<T> prev = null
        Node<T> next = null
    }

    void unshift(T value) {
        Node<T> head = new Node<T>(value: value, next: first)
        if (first) {
            first.prev = head
        }
        first = head

        if (!last) {
            last = first
        }
    }

    T shift() {
        if (first) {
            T value = first.value
            first = first.next
            if (first) {
                first.prev = null
            } else {
                last = null
            }
            value
        } else {
            throw new NoSuchElementException()
        }
    }

    T pop() {
        if (last) {
            T value = last.value
            last = last.prev
            if (last) {
                last.next = null
            } else {
                first = null
            }
            value
        } else {
            throw new EmptyStackException()
        }
    }

    void push(T value) {
        Node<T> tail = new Node<T>(value: value, prev: last)
        if (last) {
            last.next = tail
        }
        last = tail

        if (!first) {
            first = last
        }
    }
}
