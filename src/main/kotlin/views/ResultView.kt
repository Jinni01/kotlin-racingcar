package views

import domain.racingcar.dto.RaceHistoryDto
import domain.racingcar.dto.StepHistoryDto

class ResultView {

    companion object {
        private const val FOOTPRINTS_SYMBOL = "-"

        fun printRaceHistory(raceHistory: RaceHistoryDto) {

          raceHistory.stepHistories.forEach() {
              printStepHistory(it)
              println()
          }
        }

        private fun printStepHistory(stepHistory: StepHistoryDto) {

            stepHistory.positions.forEach() {
                for (i in 1..it) {
                    print(FOOTPRINTS_SYMBOL)
                }
                println()
            }
        }
    }
}