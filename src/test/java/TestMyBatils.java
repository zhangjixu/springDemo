import com.cn.dao.CustomerDao;
import com.cn.dao.PersonDao;
import com.cn.model.User;
import com.cn.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/20
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:springmvc-servlet.xml"})
public class TestMyBatils {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testQueryCustomer() {
        System.out.println(customerDao.getCustomer(1));
    }

    @Test
    public void testGetCity() {
        System.out.println(personDao.getCity(1));
    }

    @Test
    public void testQueryPerson() {
        System.out.println(personDao.getPerson(1));
    }

    @Test
    public void testQueryAllUser() {
        List<User> userList = userDao.queryAllUser();
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void testQqueryUserById() {
        User user = userDao.queryUserById(3);
        System.out.println(user);
    }

    @Test
    public void testQuery() {
        Map map = userDao.query(2);
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setAge(20);
        user.setName("李四");
        System.out.println(userDao.addUser(user));
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setName("李四");
        user.setAge(20);
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(3);

    }

}
