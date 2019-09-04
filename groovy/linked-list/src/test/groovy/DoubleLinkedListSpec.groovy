import spock.lang.*

class DoubleLinkedListSpec extends Specification {

    def "Can push and pop"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(10)
        list.push(20)

        then:
        list.pop() == 20

        and:
        list.pop() == 10
    }

    def "Can push and shift"() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()

        when:
        list.push('10')
        list.push('20')

        then:
        list.shift() == '10'

        and:
        list.shift() == '20'
    }

    def "Can unshift an shift"() {
        DoubleLinkedList<Character> list = new DoubleLinkedList<>()

        when:
        list.unshift('1' as Character)
        list.unshift('2' as Character)

        then:
        list.shift() == '2'

        and:
        list.shift() == '1'
    }

    def "Can unshift and pop"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.unshift(10)
        list.unshift(20)

        then:
        list.pop() == 10

        and:
        list.pop() == 20
    }

    def "Complete example"() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()

        when:
        list.push('ten')
        list.push('twenty')

        then:
        list.pop() == 'twenty'

        when:
        list.push('thirty')

        then:
        list.shift() == 'ten'

        when:
        list.unshift('forty')
        list.push('fifty')

        then:
        list.shift() == 'forty'
        list.pop() == 'fifty'
        list.shift() == 'thirty'
    }

    def "Should shift and pop on 2-elem list reset the list"() {
        given:
        DoubleLinkedList<String> list = new DoubleLinkedList<>()
        list.push('a')
        list.push('b')
        when:
        def shiftResult = list.shift()
        and:
        def popResult = list.pop()
        then:
        shiftResult == 'a' && popResult == 'b'
        and:
        list.isEmpty()
    }

    def "Should pop and shift on 2-elem list reset the list"() {
        given:
        DoubleLinkedList<String> list = new DoubleLinkedList<>()
        list.push('a')
        list.push('b')
        when:
        def popResult = list.pop()
        and:
        def shiftResult = list.shift()
        then:
        shiftResult == 'a' && popResult == 'b'
        and:
        list.isEmpty()
    }

    @Unroll
    def "Should clean list (#summary)"() {
        given:
        DoubleLinkedList<String> list = new DoubleLinkedList<>()
        when:
        applyHistory(list)
        then:
        list.isEmpty()
        where:
        [applyHistory, summary] << [
                [{ it.push('a'); it.shift() }, "push|shift"],
                [{ it.push('a'); it.pop() }, "push|pop"],
                [{ it.unshift('a'); it.shift() }, "unshift|shift"],
                [{ it.unshift('a'); it.pop() }, "unshift|pop"],
                [{ it.push('a'); it.push('b'); it.shift(); it.shift() }, "push|push|shift|shift"],
                [{ it.push('a'); it.unshift('b'); it.pop(); it.shift() }, "push|unshift|pop|shift"]
        ]
    }

    @Unroll
    def "Should throw an exception on attempt to #summary data from an empty list"() {
        given:
        DoubleLinkedList<String> list = new DoubleLinkedList<String>()
        when:
        operation(list)
        then:
        thrown(exception)
        where:
        [operation, exception, summary] << [
                [{ it.shift() }, NoSuchElementException, "shift"],
                [{ it.pop() }, EmptyStackException, "pop"],
        ]

    }
}
