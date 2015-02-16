package examples.groovy

import spock.lang.Specification

class GroovyFeatures extends Specification {

    def "Maps are really nice"() {
        when:
        def aMap = [key1: "value1", key2 : "value2", key3: "value3"]


        then:
        aMap == new HashMap() {}
    }
}
