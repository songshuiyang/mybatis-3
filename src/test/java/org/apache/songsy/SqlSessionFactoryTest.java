package org.apache.songsy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
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
    public void test1() throws Exception {
        File file = new File("src/test/java/resources/mybatis-config.xml");
        InputStream inputStream = new FileInputStream(file);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectByPrimaryKey(1));
    }
}
