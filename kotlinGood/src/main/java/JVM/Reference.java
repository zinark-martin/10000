package JVM;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class Reference {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(str, referenceQueue);

        str = null;
        // Notify GC
        System.gc();
        Thread.sleep(2000);

        System.out.println(softReference.get()); // abc

        java.lang.ref.Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference); //null

    }
}