import okio.Buffer
import okio.ByteString.Companion.encodeUtf8
import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {
    val buffer = Buffer()
    println(buffer)
    buffer.write("123456".encodeUtf8())
    println(buffer.writeInt(8))
    println(buffer.writeUtf8("hi Bitch").writeUtf8("成功连接"))
    while (!buffer.exhausted()) {
        println(buffer.readUtf8(1))
    }
    val bufferInOut = Buffer()
    bufferInOut.readFrom(FileInputStream("src"))
    bufferInOut.writeTo(FileOutputStream("des"))
    println(bufferInOut)
}