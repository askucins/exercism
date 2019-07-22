class Bob {

    static Boolean isQuestion(input) {
        input ==~ /.*?\?\s*\z/
    }

    static Boolean isYelled(input) {
        input ==~ /[^a-z]+/ && input =~ /[A-Z]+/
    }

    static Boolean isYelledQuestion(input) {
        isYelled(input) && isQuestion(input)
    }

    static Boolean isEmpty(input) {
        input ==~ /\s*/
    }

    //Wrapping-up with closures is mandatory!
    //See e.g. https://mrhaki.blogspot.com/2009/08/groovy-goodness-switch-statement.html
    /*
        "Anything that implements the isCase() method can be used as a classifier.
        Groovy already added an isCase() method to
        Class (uses isInstance),
        Object (uses (equals),
        collections (uses contains)
        and regular expressions (uses matches).
        If we implement the isCase method in our own Groovy classes we can use it as a classifier as well.
        Finally we can use a closure as a classifier.
        The closure will be evaluated to a boolean value."
     */

    static response(input) {
        def result = ''
        switch (input) {
            case { isYelledQuestion(it) }:
                result = "Calm down, I know what I'm doing!"
                break
            case { isYelled(it) }:
                result = 'Whoa, chill out!'
                break
            case { isQuestion(it) }:
                result = 'Sure.'
                break
            case { isEmpty(it) }:
                result = 'Fine. Be that way!'
                break
            default:
                result = 'Whatever.'
        }
        result
    }
}