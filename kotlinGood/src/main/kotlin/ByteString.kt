import okio.ByteString.Companion.decodeBase64
import okio.ByteString.Companion.encodeUtf8
import okio.ByteString.Companion.readByteString
import java.io.FileInputStream
import java.io.FileOutputStream


/*"Base64是用来吧二进制数据变成ASCII美国信息交换标准代码
sha1和md5都是不可逆向的把数据转换成十六进制码,可用于校验数据是否匹配
ByteString中提供了方法可以将base64解码或将数据转换成以上的形式"*/

fun main() {
    val str = "this is a string"
    println(str.length)
    val byteString= str.encodeUtf8()
    println(byteString)
    val str2 = byteString.base64()
    println(str2)
    val md5 = byteString.md5()
    println(md5.base64())
    println("YWJj".decodeBase64())
    println(byteString.sha1().hex())


    //读取图片
    val input = FileInputStream("path")
    val ByteString = input.readByteString(input.available())
    //读取长度是有多少读取多少
    //不需要使用循环，一次读到read里然后再用read读出写出到输出流中 过程中read先放进数据又去除数据
    val out = FileOutputStream("out.jpeg")
    ByteString.write(out)
    //IO中是用流的写入方法, 把括号里的数组写进FileOutputString流内;
    // 这里是用byteString的写入方法,把ByteString写到括号里的流内
    //体现了ByteString是充电宝的效果
    input.close()
    out.close()

    /*使用Java io 从文件读取内容*/
    val fileIn = FileInputStream("path")
    val carry = ByteArray(1024)
    fileIn.read(carry) //把文件数据读到数组中
    //完整版如下
    var i: Int
    val stringBuilder = StringBuilder()
    val fileOut = FileOutputStream("der")
    while (fileIn.read(carry).also { i = it } != -1) {
        stringBuilder.append(carry) //相当于是write了
        fileOut.write(carry) //也可以这个样写, 即读进carry, 写把carry写出
    }
    println(stringBuilder.toString())
}