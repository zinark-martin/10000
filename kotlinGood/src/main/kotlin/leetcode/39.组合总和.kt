//package leetcode
//
//import java.util.*
//import kotlin.collections.ArrayList
//import kotlin.collections.HashMap
//
//
//fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
//    candidates.sort()
//    var car: List<List<Int>> = listOf()
//    var map: Map<Int, Set<List<Int>>> = mapOf()
//    val min = candidates.first()
//    for (key in min..target) {
//        map
//    }
//
//    for (key in min..target) {
//        for (num in candidates) {
//            if (num > key) break
//            else if (num == key) car.apply { listOf(num) }
//            var diff = key - num
//        }
//    }
//}
//fun main() {
//    combinationSum(intArrayOf(2,3,4,5,7,8,9), 7)
//}