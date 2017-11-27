package demo

import demo.pages.CreatePersonPage
import demo.pages.PersonListPage
import demo.pages.ShowPersonPage
import geb.spock.GebSpec

// tag::class_declaration[]
import grails.testing.mixin.integration.Integration
import spock.lang.Stepwise

@Integration
@Stepwise
class PersonCrudFunctionalSpec extends GebSpec {

// end::class_declaration[]

// tag::test_create[]
    void "test creating people"() {
        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        def form = $('form')
        form.firstName = 'Geddy'
        form.lastName = 'Lee'
        form.age = '63'
        form.create().click()

        then:
        at ShowPersonPage

        when:
        to CreatePersonPage

        then:
        at CreatePersonPage

        when:
        form = $('form')
        form.firstName = 'Alex'
        form.lastName = 'Lifeson'
        form.age = '63'
        form.create().click()

        then:
        at ShowPersonPage
    }
// end::test_create[]

// tag::test_retrieve[]
    void "test retrieving people"() {
        when:
        to PersonListPage

        then:
        numberOfPersonRows == 2
    }
// end::test_retrieve[]
// tag::class_declaration[]
}
// end::class_declaration[]
