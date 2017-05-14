package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {

    @Autowired
    private SecKillDao secKillDao;

    @Test
    public void reduceNumber() throws Exception {
        int updateCount = secKillDao.reduceNumber(1000L, new Date());
        assertEquals(updateCount, 1);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = secKillDao.queryById(1000);
        assertNotNull(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = secKillDao.queryAll(0, 10);
        assertEquals(4, seckills.size());
    }

}