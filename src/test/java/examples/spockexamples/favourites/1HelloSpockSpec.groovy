package examples.spockexamples.favourites

import spock.lang.Unroll

/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class HelloSpockSpec extends spock.lang.Specification {
    def "Length of Spock's name"() {
        when:
        String name = "Spock"

        then:
        name.size() == 5
    }

    def "Length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def "Length of Spock's and his friends' names 2"(String name, int length) {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    @Unroll
    def "Length of #name's name is #length"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    @Unroll("Length of #name's name is #length")
    def "Length of Spock's and his friends' names "() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def """Really really really long 'test' methods are both a blessing
            and a curse. It's up to you to strike the right balance"""() {
        when:
        String name = "Spock"

        then:
        name.size() == 5
    }

    @Unroll
    def """Really really really long 'test' methods are both a blessing
            and a curse. It's up to you to strike the right balance #name #length"""() {
        expect:
        name.size() == length

        where:
        name << ["Spock", "Scotty", "Kirk"]
        length << [5, 6, 4]
    }

    @Unroll
    def "Really really really long 'test' methods are both a blessing and a curse. It's up to you to strike the right balance #name #length"() {
        expect:
        name.size() == length

        where:
        name << ["Spock", "Scotty", "Kirk"]
        length << [5, 6, 4]
    }

    def "Descriptive spec/test summaries can be combined with detailed step comments"() {
        given: "We want to explain extra details"

        when: "We script the test"
        String name = "Spock"

        then: "Spock provides support for doing"
        name.size() == 5
    }

    // @IgnoreRest

    // Use Annotations to group include, exclude certain tests
    // from particular test runs e.g
    // Sanity
    // Slow
    // Requires-Blah e.g. RequiresRapid <- perhaps it's not reliable

}