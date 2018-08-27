package pl.greywarden.parser.rpn


import spock.lang.Specification
import spock.util.matcher.HamcrestMatchers

class OperatorsTest extends Specification {

    def 'should check if token is operator'(String token, boolean isOperator) {
        given:
        def operators = new Operators()

        when:
        def result = operators.isOperator(token)

        then:
        result == isOperator

        where:
        token | isOperator
        '+'   | true
        '-'   | true
        'X'   | false
        '%'   | false
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def 'should perform operation'(Double x, Double y, String token, Double expected) {
        given:
        def operators = new Operators()

        when:
        def result = operators.performOperation(x, y, token)

        then:
        result HamcrestMatchers.closeTo(expected, 0.001)

        where:
        x   | y   | token | expected
        2.0 | 2.0 | '+'   | 4.0
        2.5 | 3.5 | '+'   | 6.0
        2.2 | 1.7 | '-'   | 0.5
    }

}
