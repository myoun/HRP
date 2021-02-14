package org.projecttl.plugin.hrp

class TestClass {

    fun testLet() {
        val test = "Name".let { personalName ->
            println("What's your $personalName")

            personalName
        }

        println(test)
    }
}