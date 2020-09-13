
import okio.BufferedSink

import okio.buffer
import okio.sink
import okio.source
import java.io.File

object BufferTest2 {
    /* 水，从 “源” 流向 “水池” */
    fun main(args: Array<String>) {
        //(我们要 BufferedSink/BufferSource)
        val sink: BufferedSink = File("out.txt").sink().buffer() //数据接收方
        //数据供应方
        val source = File("in.txt").source().buffer().apply {
          readAll(sink)
        }//完成读写, 比起刚才的更简洁一些
        source.close()
        sink.close()
    }
}
/*
 * Source中带有的方法 (okio中和输入流对应的接口!)
 * read(Buffer sink, long byteCount)
 * timeout() 读取超时处理
 * close()   关闭流以释放资源
 * Sink中带有的方法  (okio中和输出流对应的接口!)
 * write(Buffer source,long byteCount)
 * flush() 将缓存的数据写入目的地
 * timeout() 同上
 * close() 同上*/