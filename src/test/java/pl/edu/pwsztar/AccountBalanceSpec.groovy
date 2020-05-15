package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class AccountBalanceSpec extends Specification{

    @Unroll
    def "should return #cash cash for #account account"(){
        given: "Initial data"
            def bank = new Bank()
            def accounts = SampleDataGenerator.accountsList
            bank.addSampleAccounts(accounts)
        when: "get account balance"
            def balance = bank.accountBalance(account)
        then: "check balance"
            balance == cash

        where:
            account | cash
                1   | 250
                2   | 100
                3   | 300
                4   | 200
    }
}
