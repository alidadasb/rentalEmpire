package com.dorisoft.rental

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Build([Organization,Property])
class OrganizationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create new Organization, with one commercial property"() {
        given:
        def org = Organization.buildWithoutSave(name: "Dorisa")

        when:
        org.addToProperties(Property.build(name: "Shiny", propertyType:PropertyType.COMMERCIAL) )

        then:
        Organization.count() == 1
        Property.count == 1
    }
}
