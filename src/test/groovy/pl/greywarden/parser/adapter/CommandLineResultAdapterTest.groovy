package pl.greywarden.parser.adapter

import pl.greywarden.parser.error.RpnValidationException
import spock.lang.Specification

class CommandLineResultAdapterTest extends Specification {

    private PrintStream printStream

    def setup() {
        printStream = Mock(PrintStream)
        System.out = printStream
        System.err = printStream
    }

    def "should print info"() {
        given:
        def resultAdapter = new CommandLineResultAdapter()
        def message = "message"

        when:
        resultAdapter.info(message)

        then:
        1 * printStream.println(_ as String)
    }

    def "should print exception in system err"() {
        given:
        def resultAdapter = new CommandLineResultAdapter()
        def exception = new RpnValidationException('2', '2', '+', '+')

        when:
        resultAdapter.error(exception)

        then:
        1 * printStream.println(_ as String)
    }
}
