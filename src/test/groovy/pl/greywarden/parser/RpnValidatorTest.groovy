package pl.greywarden.parser

import pl.greywarden.parser.error.RpnValidationException
import pl.greywarden.parser.rpn.RpnValidator
import spock.lang.Specification

class RpnValidatorTest extends Specification {

    def 'should validate rpn'(String[] rpn) {
        given:
        def parser = new RpnValidator()

        when:
        parser.validateRpn(rpn)

        then:
        noExceptionThrown()

        where:
        rpn                                                                                            | _
        ['2', '5', '+', '7', '+', '2.5', '+', '17', '+', '22', '+', '18', '-', '1', '+', '2', '-']     | _
        ['2', '5', '-', '2', '+', '4', '+', '17', '-', '2.2', '+', '0.17', '-', '2.5', '+', '22', '+'] | _
        ['-17', '5', '+', '3', '+', '3.1415', '-', '22222222222', '+', '3', '-']                       | _
    }

    def 'should fail on validation'(String[] rpn) {
        given:
        def parser = new RpnValidator()

        when:
        parser.validateRpn(rpn)

        then:
        thrown(RpnValidationException)

        where:
        rpn                                                                                                | _
        ['2', '5', '+', '7', '+', '2.5', '+', '17', '+', '22', '+', '18', '-', '1', '+', '+', '-']         | _
        ['2', '5', '-', '2', '+', '4', '+', '17', '-', '2.2', '+', '0.17', '-', '2.5', '+', '0x1111', '+'] | _
        ['-17', '5', '+', '3', '+', '3.broken15', '-', '22222222222', '+', '3', '-']                       | _
    }


}
