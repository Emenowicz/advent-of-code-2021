package menu

import task0.Problem
import task0.Unknown
import task1.SonarSweep

class Menu {
    companion object {

        @JvmStatic
        fun menu() {
            printWelcome()
            while (true) {
                printMenu()
                val selection = readLine()
                if (!selection.equals("exit", true)) {
                    val problem: Problem = when (selection?.toInt() ?: 0) {
                        1 -> SonarSweep()
                        else -> Unknown()
                    }
                    printSolution(problem)
                } else {
                    printGoodbye()
                    return
                }
            }
        }

        private fun printWelcome() {
            println("Welcome to Advent of Code solutions solved by Dawid Michałowicz")
        }

        private fun printMenu() {
            println("Select problem to solve by writing its number:")
            println("1. Sonar Sweep")

            println("Write 'exit' to finish")
        }


        private fun printSolution(problem: Problem) {
            print("Solution is: ")
            problem.printSolution()
            print("\n\n")
        }

        private fun printGoodbye(){
            print("Thanks, bye!")
        }
    }
}