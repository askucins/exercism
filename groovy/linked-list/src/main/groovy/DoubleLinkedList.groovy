import groovy.transform.Canonical

@Canonical
class Node<T> {
    T value
    Node<T> prev = null
    Node<T> next = null
}

@Canonical
class DoubleLinkedList<T> {
    Node<T> first = null
    Node<T> last = null

    void unshift(T value) {
        Node<T> head = new Node<T>(value: value, next: first)
        if (first) {
            first.prev = head
        }
        first = head

        if (!last) {
            last = head
        }
    }

    T shift() {
        T value = first.value
        first = first.next
        if (first) {
            first.prev = null
        }
        value
    }

    T pop() {
        T value = last.value
        last = last.prev
        if (last) {
            last.next = null
        }
        value
    }

    void push(T value) {
        Node<T> tail = new Node<T>(value: value, prev: last)
        if (last) {
            last.next = tail
        }
        last = tail

        if (!first) {
            first = tail
        }
    }
}
