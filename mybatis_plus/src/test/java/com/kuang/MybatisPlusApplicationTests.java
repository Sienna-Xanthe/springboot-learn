package com.kuang;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //测试插入
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("787狂神说Java");
        user.setAge(28);
        user.setEmail("34523324@qq.com");

        int result = userMapper.insert(user);//自动生成id  雪花算法
        System.out.println(result);
        System.out.println(user);
    }

    //测试更新
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1507174935515049989L);
        user.setName("阿三大苏打：狂神说Java");
        user.setAge(1);
        user.setEmail("34523324@qq.com");

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //2.修改用户信息
        user.setName("kuangshen");
        user.setEmail("439857456@qq.com");
        //3.执行更新执行
        userMapper.updateById(user);
    }


    //测试乐观锁失败!多线程下
    @Test
    public void testOptimisticLocker2(){
        //线程1
        User user = userMapper.selectById(1L);
        user.setName("11111111kuangshen");
        user.setEmail("439857456@qq.com");


        //模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("22222222kuangshen");
        user2.setEmail("439857456@qq.com");
        userMapper.updateById(user2);

        // 自旋锁来多次尝试提交
        userMapper.updateById(user);//如果没有乐观锁就会覆盖插队线程的值
    }

    //测试查询
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //测试批量查询
    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    //条件查询map
    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","狂神说Java");
        map.put("age",23);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        long total = page.getTotal();
        System.out.println(total);

    }

    //删除测试
    @Test
    public void testDeleteById() {
        userMapper.deleteById(1L);
    }

    //测试批量删除
    @Test
    public void testDeleteBatchId() {
        userMapper.deleteBatchIds(Arrays.asList(1507174935515049988L,1507174935515049989L));
    }

    //测试map删除
    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","阿三大苏打：狂神说Java");
        userMapper.deleteByMap(map);
    }


}
