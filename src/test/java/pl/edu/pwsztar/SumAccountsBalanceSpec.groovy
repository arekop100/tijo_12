package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class SumAccountsBalanceSpec extends Specification{

    @Unroll
    def "should sum and return 850 from all accounts"(){
        given: "Initial data"
            def bank = new Bank()
            def accounts = SampleDataGenerator.accountsList
            bank.addSampleAccounts(accounts)
        when: "sum balance from all accounts"
            def result = bank.sumAccountsBalance()
        then: "check sum"
            result == 850

    }
}
