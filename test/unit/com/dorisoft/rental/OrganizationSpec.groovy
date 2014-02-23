package com.dorisoft.rental

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Build([Organization,RentalProperty])
class OrganizationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Create new Organization, with one commercial property"() {
        given:
        def org = Organization.buildWithoutSave(name: "Dorisa")

        when:
        org.addToRentalProperties(RentalProperty.build(name: "Shiny1", propertyType:PropertyType.COMMERCIAL) )
        org.addToRentalProperties(RentalProperty.build(name: "Shiny2", propertyType:PropertyType.COMMERCIAL) )
        org.addToRentalProperties(RentalProperty.build(name: "Shiny3", propertyType:PropertyType.COMMERCIAL) )
        org.addToRentalProperties(RentalProperty.build(name: "Shiny4", propertyType:PropertyType.COMMERCIAL) )
        org.save()

        then:
        Organization.count() == 1
        RentalProperty.count == 4
    }

}
