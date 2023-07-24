package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver

class EntryArgumentResolverTest : ExpectSpec({

    context("EntryArgumentResolver test") {
        expect("validate test - valid format") {
            val resolver = EntryArgumentResolver()
            val validate = resolver.validate("test1,test2,test3")

            validate shouldBe true
        }

        expect("validate test - invalid format 1") {
            val resolver = EntryArgumentResolver()
            val validate = resolver.validate(",,,")

            validate shouldBe false
        }

        expect("validate test - invalid format 2") {
            val resolver = EntryArgumentResolver()
            val validate = resolver.validate(",test2,test3")

            validate shouldBe false
        }

        expect("validate test - invalid format 3") {
            val resolver = EntryArgumentResolver()
            val validate = resolver.validate("test2,test3,")

            validate shouldBe false
        }

        expect("validate test - racer name length > 5") {
            val resolver = EntryArgumentResolver()
            val validate = resolver.validate("tester1,tester2")

            validate shouldBe false
        }

        expect("resolve test") {
            val resolver = EntryArgumentResolver()
            val resolve = resolver.resolve("test1,test2,test3")

            resolve.value shouldBe listOf("test1", "test2", "test3")
        }
    }
})
