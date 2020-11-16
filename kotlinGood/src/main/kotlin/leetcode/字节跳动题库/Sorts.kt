package leetcode.字节跳动题库//package leetcode.字节跳动题库

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low >= high) {
        //若这组数字只有一位数,结束这一组操作
        return
    }
    //基准数,这里就是每组的第一个
    val pivot = arr[low]
    var start= low
    var end = high
    //------------------指针碰撞时结束这一层排序--------------------
    while (start < end) {
        //右边当发现小于基准的值时停止循环 (或指针碰撞)
        while (arr[end] >= pivot && start < end) {
            end--
        }
        //左边当发现大于基准的值时停止循环 (或指针碰撞)
        while (arr[start] <= pivot && start < end) {
            start++
        }
        if (start >= end)  break
        //两个指针碰撞 则指向同一个不需要交换 故跳出循环
        val temp = arr[end]
        arr[end] = arr[start]
        arr[start] = temp
    }
    //------------------指针碰撞时结束这一层排序--------------------
    //将pivot和两个指针碰撞的这个位置数字交换 (只有两个数字的时候 碰撞指针和基准数字是同一个)
    arr[low] = arr[end] // (arr[low]就是pivot哦 不用缓存)
    arr[end] = pivot
    //递归地处理左右子数组
    quickSort(arr, low, end - 1) //对左边快排
    quickSort(arr, end + 1, high) //对右边快排
}
fun main() {
    val arr = intArrayOf(3,4,4,6,6,8,9,10)
    quickSort(arr, 0, arr.size - 1)
    println(arr.contentToString())
}