package strikt.arrow.option

import arrow.core.Option
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

object OptionAssertionsTest : Spek({

    describe("Option.Some") {

        val option = Option.just("aValue")

        it("can assert on type") {
            expectThat(option).isSome()
        }

        it("can negate") {
            expectThat(option).not().isNone()
        }

        it("can assert on type and value") {
            expectThat(option).isSome("aValue")
        }

        it("can assert on type and with custom predicate") {
            expectThat(option).isSomeWhere { it == "aValue" }
        }

        it("can chain assertion on narrowed type") {
            expectThat(option)
                .isSome()
                .get { t }
                .isEqualTo("aValue")
        }
    }

    describe("Option.None") {

        val option = Option.empty<String>()

        it("can assert on type") {
            expectThat(option).isNone()
        }

        it("can negate") {
            expectThat(option).not().isSome()
        }
    }

})
