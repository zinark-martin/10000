package leetcode

fun replaceSpaces(S: String, length: Int): String {
    //subString用来将其变为参数给定大小的数组
   return S.substring(0, length).replace(" ", "%20")
}
