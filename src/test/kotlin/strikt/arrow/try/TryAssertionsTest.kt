package strikt.arrow.`try`

import arrow.core.Try
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

object TryAssertionsTest : Spek({

    describe("Try.Success") {
        val aTry = Try.just("success")

        it("can assert on type") {
            expectThat(aTry).isSuccess()
        }

        it("can negate") {
            expectThat(aTry).not().isFailure()
        }

        it("can assert on type and value") {
            expectThat(aTry).isSuccess("success")
        }

        it("can assert on type and with custom predicate") {
            expectThat(aTry).isSuccessWhere { it == "success" }
        }

        it("can chain on narrowed type") {
            expectThat(aTry)
                .isSuccess()
                .get { value }
                .isEqualTo("success")
        }
    }

    describe("Try.Failure") {
        val aTry: Try<String> = Try.raiseError(IllegalArgumentException("testFailure"))

        it("can assert on type") {
            expectThat(aTry).isFailure()
        }

        it("can negate") {
            expectThat(aTry).not().isSuccess()
        }

        it("can assert on type and with custom predicate") {
            expectThat(aTry).isFailureWhere { it.message == "testFailure" }
        }

        it("can chain on narrowed type") {
            expectThat(aTry)
                .isFailure()
                .get { exception.message }
                .isEqualTo("testFailure")
        }

        /*
        it("can chain on narrowed type") {
            expectThat(aTry)
                .isFailureOfType<IllegalArgumentException>()
        }
         */
    }

})
