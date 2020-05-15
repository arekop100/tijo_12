package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DepositSpec extends Specification{

    @Unroll
    def "should deposit #cashToDeposit cash to account number #accountNumber"(){

        given: "initial data"
            def accounts = SampleDataGenerator.accountsList
            def bank = new Bank()
            bank.addSampleAccounts(accounts)
        when: "deposit cash to account"
            def result = bank.deposit(accountNumber, cashToDeposit)
        then: "check if deposit is successful"
            result

        where:
            accountNumber | cashToDeposit
                  1       |       250
                  2       |       100
                  3       |       300
                  4       |       200
    }
}
