package org.apache.songsy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.apache.songsy.entity.User;
import org.apache.songsy.mapper.UserMapper;
import org.hsqldb.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * @author songsy
 * @Date 2018/11/21 15:06
 */
@RunWith(MockitoJUnitRunner.class)
public class SqlSessionFactoryTest {


    @Test
    public void core() throws Exception {
        // 读取配置文件
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectByPrimaryKey(1));
    }

    @Test
    public void level1CacheTest() throws Exception {
        // 读取配置文件
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("第一次查询: "+userMapper.selectByPrimaryKey(1));
        System.out.println("第二次查询: "+userMapper.selectByPrimaryKey(1));
    }




    @Test
    public void methodCacheTest() throws Exception {
        // 读取配置文件
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到Mapper
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        // 测试methodCache
        UserMapper userMapper2 = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper1.selectByPrimaryKey(1));
    }

    @Test
    public void updateUserTest() throws Exception {
        // 读取配置文件
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到Mapper
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setNickname("songsy");
        System.out.println(userMapper1.updateByPrimaryKeySelective(user));
    }

    @Test
    public void selectSelectiveUserTest() throws Exception {
        // 读取配置文件
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到Mapper
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        System.out.println(userMapper1.selectSelective(user));
    }


}
