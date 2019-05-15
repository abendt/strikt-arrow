package strikt.arrow.either

import arrow.core.Either
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import strikt.api.expectThat
import strikt.assertions.isEqualTo

object EitherAssertionsTest : Spek({

    describe("Either.left") {

        val anEither = Either.left("left")

        it("can check on type") {
            expectThat(anEither).isLeft()
        }

        it("can check on type and value") {
            expectThat(anEither).isLeft("left")
        }

        it("can check on type with own predicate") {
            expectThat(anEither).isLeftWhere { it == "left" }
        }

        it("can chain assertion on narrowed type") {
            expectThat(anEither).isLeft()
                .get { a }
                .isEqualTo("left")
        }
    }

    describe("Either.right") {

        val anEither = Either.right("right")

        it("can check on type") {
            expectThat(anEither).isRight()
        }

        it("can check on type and value") {
            expectThat(anEither).isRight("right")
        }

        it("can check on type with own predicate") {
            expectThat(anEither).isRightWhere { it == "right" }
        }

        it("can chain assertion on narrowed type") {
            expectThat(anEither).isRight()
                .get { b }
                .isEqualTo("right")
        }
    }

})
