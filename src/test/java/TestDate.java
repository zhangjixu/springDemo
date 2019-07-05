import java.net.URL;
import java.security.ProtectionDomain;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/9/5
 * @Description:
 * @Version: 1.0.0
 */
public class TestDate {


    @org.junit.Test
    public void testDate() {
        ProtectionDomain protectionDomain = TestDate.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();
        String warFile = location.toExternalForm();
        System.out.println(warFile);

    }

}
