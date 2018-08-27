package pl.greywarden.parser.provider

import spock.lang.Specification

class InputParamsRpnTokenProviderTest extends Specification {

    def "should get tokens"() {
        given:
        String[] args = ['2', '2', '+']
        def tokenProvider = new InputParamsRpnTokenProvider()

        when:
        def tokens = tokenProvider.getTokens(args)

        then:
        tokens == args
    }

    def "should fail when tokens not provided"() {
        given:
        def tokenProvider = new InputParamsRpnTokenProvider()

        when:
        tokenProvider.getTokens(null)

        then:
        thrown(IllegalArgumentException)
    }

}
