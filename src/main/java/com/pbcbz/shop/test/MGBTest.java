package com.pbcbz.shop.test;

import com.pbcbz.shop.entities.Employee;
import com.pbcbz.shop.mappers.EmployeeMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.util.Iterator;

public class MGBTest {
    
    public static void main(String[] args){
        
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        InputStream inputStream = MGBTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis-config" 
                + ".xml");
        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();
        
        //按照java方式整合通用mapper的特殊设置
        //1、创建MapperHelper对象
        MapperHelper mapperHelper = new MapperHelper();
        
        //2、通过MapperHelper对mybatis原生的Configuration对象进行处理
        Configuration configuration = session.getConfiguration();
        mapperHelper.processConfiguration(configuration);

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        
        Iterator <Employee> iterator = mapper.selectAll().iterator();
        
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
}
