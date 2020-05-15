package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification{

    @Unroll
    def "should delete account number #accountNumber with cash #accountCash"(){

        given: "initial data"
            def bank = new Bank()
            def accounts = SampleDataGenerator.accountsList
            bank.addSampleAccounts(accounts)

        when: "account deleted"
            def cash = bank.deleteAccount(accountNumber)
        then: "check deleted account cash"
            cash == accountCash

        where:
            accountNumber | accountCash
                1         |     200
                2         |     0
                3         |     450
                4         |     100
    }


}
