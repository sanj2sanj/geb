/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package browser

// tag::class[]
import geb.Page
import geb.spock.GebSpec

class GoogleHomePage extends Page {
    static url = "http://www.google.com/ncr"
}

class GoogleSpec extends GebSpec {
    def "go method does NOT set the page"() {
        given:
        Page oldPage = page

        when:
        go "http://www.google.com/ncr"

        then:
        oldPage == page
        currentUrl == "http://www.google.com/"
    }

    def "to method does set the page and change the current url"() {
        given:
        Page oldPage = page

        when:
        to GoogleHomePage

        then:
        oldPage != page
        currentUrl == "http://www.google.com/"
    }
}
// end::class[]