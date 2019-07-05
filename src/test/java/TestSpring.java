import com.cn.serviceImpl.MysqlOpsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/15
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class TestSpring {

    @Autowired
    private MysqlOpsImpl mysqlOpsImpl;


    @Test
    public void test() {
        try {
            mysqlOpsImpl.test();
        } catch (Exception e) {
            System.out.println("      " + e.getMessage());
        }
    }

    @Test
    public void test1() {
    }

}
