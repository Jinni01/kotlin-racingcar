import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class MyKotlinTest : ExpectSpec({

    context("domain test: Person") {
        expect("named argument test") {
            val person = Person(name = "심의진", age = 22, nickname = "Jinni01")

            person.name shouldBe "삼의진"
        }

        expect("nullable parameter test") {
            val person = Person.of("심의진", 22)

            person.nickname shouldBe null
        }

        expect("data class test") {
            val person = Person(name = "심의진", age = 22, nickname = "Jinni01")
            val other = Person(name = "신의진", age = 22, nickname = "Jinni001")

            val shouldBeTypeOf = person.shouldBeTypeOf<Person>()
            //same reference
            shouldBeTypeOf.nickname = "Jinni02"

            person.age shouldBe other.age
        }
    }

})