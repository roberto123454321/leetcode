package com.roberto.adventofcode.year2024

import java.io.FileReader
import kotlin.math.abs

class Day2 {
    /**
     * 670
     */
    fun countSafeReports(): Int {
        val reports = loadReports()

        var successfulReportsCount = 0

        for (report in reports) {
            if (isReportAscOrDesc(report) && areReportDiffsCorrect(report)) {
                successfulReportsCount++
            }
        }

        return successfulReportsCount
    }

    /**
     * 700
     */
    fun countSafeReportsWithProblemDampener(): Int {
        val reports = loadReports()

        var successfulReportsCount = 0

        for (report in reports) {

            if (isReportAscOrDesc(report) && areReportDiffsCorrect(report)) {
                successfulReportsCount++
                continue
            }

            //problem dumper
            for (i in 0 until report.size) {
                val modifiedReport = report.toMutableList()
                modifiedReport.removeAt(i)

                if (isReportAscOrDesc(modifiedReport) && areReportDiffsCorrect(modifiedReport)) {
                    successfulReportsCount++
                    break
                }
            }

        }
        return successfulReportsCount
    }

    private fun areReportDiffsCorrect(report: MutableList<Int>): Boolean {
        for (i in 0 until report.size - 1) {
            val diff = abs(report[i] - report[i + 1])
            if (diff < 1 || diff > 3) {
                return false
            }
        }
        return true
    }

    private fun isReportAscOrDesc(report: MutableList<Int>): Boolean {
        var isAsc = true
        for (i in 0 until report.size - 1) {
            if (report[i] < report[i + 1]) {
                isAsc = false
                break
            }
        }

        var isDesc = true
        for (i in 0 until report.size - 1) {
            if (report[i] > report[i + 1]) {
                isDesc = false
                break
            }
        }

        return !(!isAsc && !isDesc)
    }

    /**
     * 686 wrong
     */
//    fun countSafeReportsWithProblemDampener(): Int {
//        val reports = loadReports()
//
//        var successfulReportsCount = 0
//
//        for (report in reports) {
//
//            var areAllAscending = true
//            var areAllDescending = true
//            var isDiffProblem = false
//
//            var isProblemDampening = false
//
//            var i = 0
//            while (i < report.size -1) {
//
//                val diff = abs(report[i] - report[i + 1])
//                if (diff < 1 || diff > 3) {
//                    if (isProblemDampening) {
//                        isDiffProblem = true
//                        break
//                    } else {
//                        isProblemDampening = true
//                        report.removeAt(i)
//                        areAllAscending = true
//                        areAllDescending = true
//                        isDiffProblem = false
//                        i = 0
//                        continue
//                    }
//                }
//
//                if (areAllAscending && report[i] > report[i + 1]) {
//                    areAllAscending = false
//                }
//
//                if (areAllDescending && report[i] < report[i + 1]) {
//                    areAllDescending = false
//                }
//
//                if (!areAllAscending && !areAllDescending) {
//                    if (isProblemDampening) {
//                        break
//                    } else {
//                        isProblemDampening = true
//                        report.removeAt(i)
//                        areAllAscending = true
//                        areAllDescending = true
//                        isDiffProblem = false
//                        i = 0
//                        continue
//                    }
//                }
//
//                i++
//            }
//
//            if (!isDiffProblem && (areAllAscending || areAllDescending)) {
//                successfulReportsCount++
//            } else {
//                print("")
//            }
//        }
//        return successfulReportsCount
//    }

    private fun loadReports(): MutableList<MutableList<Int>> {
        val reports = FileReader("$PATH_TO_INPUT_FILES_DIR/Day2Input.txt").readLines()
            .asSequence()
            .map {
                it.split(" ")
                    .map { str -> str.toInt() }
                    .toMutableList()
            }
            .toMutableList()
        return reports
    }
}
