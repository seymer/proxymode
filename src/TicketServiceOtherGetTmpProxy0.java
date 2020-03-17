/*
 * javac -encoding GBK -g -XDignore.symbol.file TicketServiceOtherGetTmpProxy0.java
 * mkdir -p com/sun/proxy
 * java TicketServiceOtherGetTmpProxy0 true 0
 * java TicketServiceOtherGetTmpProxy0 true 1 TicketServiceTmpProxy0
 * ls -l com/sun/proxy/
 */
import java.io.*;
import sun.misc.ProxyGenerator;

public class TicketServiceOtherGetTmpProxy0
{
    public static void main ( String[] argv ) throws Exception
    {
        /*
         * 如果argv[0]不为"true"，generateProxyClass()不会自动转储动态生成
         * 的类。
         */
        System.getProperties().put( "sun.misc.ProxyGenerator.saveGeneratedFiles", argv[0] );

        if ( argv[1].equals( "0" ) )
        {
            /*
             * 在当前目录下生成"com/sun/proxy/$Proxy0.class"，要求
             * "com/sun/proxy/"事先存在，否则报错
             */
            GeneralInvocationHandler2   gih = new GeneralInvocationHandler2();
            TicketService               ts  = ( TicketService )gih.bind( new TicketStation() );
        }
        else
        {
            /*
             * 在当前目录下生成"argv[2].class"，跟"com/sun/proxy/"没关系
             */
            byte[]  buf = ProxyGenerator.generateProxyClass
                    (
                            argv[2],
                            new Class[] { TicketService.class }
                    );
        }
    }
}