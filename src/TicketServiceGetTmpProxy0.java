/*
 * javac -encoding GBK -g -XDignore.symbol.file TicketServiceGetTmpProxy0.java
 * java TicketServiceGetTmpProxy0 TicketServiceTmpProxy0
 *
 * warning: ProxyGenerator is internal proprietary API and may be removed in a future release
 *
 * 为了抑制这个编译时个警告，Java 8可以指定"-XDignore.symbol.file"
 */

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/jdk8u232-ga/src/share/classes/sun/misc/ProxyGenerator.java
 */

public class TicketServiceGetTmpProxy0 {
    private static void WriteByte
            (
                    String logname,
                    /*
                     * 如果是String，可以调用"somthing".getBytes()得到byte[]
                     */
                    byte[] log
            ) {
        FileOutputStream fos;

        /*
         * 非Append模式，不存在时会自动创建
         */
        try {
            fos = new FileOutputStream(logname, false);
            fos.write(log);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  /* end of WriteByte */

    public static void main(String[] argv) throws Exception {
        byte[] buf = ProxyGenerator.generateProxyClass
                (
                        argv[0],
                        new Class[]{TicketService.class}
                );
        WriteByte(argv[0] + ".class", buf);
    }
}