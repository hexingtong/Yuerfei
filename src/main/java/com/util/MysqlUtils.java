package com.util;

import com.springmvc.pojo.Fund;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class MysqlUtils {

    public void index() throws UnsupportedEncodingException, Exception {
    //1000个一提交
        int COMMIT_SIZE=25000;
    //一共多少个
        int COUNT=100000;

        long a=System.currentTimeMillis();
        Connection conn= null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://47.92.53.177:3306/houtai?useUnicode=true&characterEncoding=utf-8";
            String user="root";
            String password="root";
            conn= DriverManager.getConnection(url,user,password);
            long starTime = System.currentTimeMillis();
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("load data local infile '' "+ "into table loadtest fields terminated by ','");
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= COUNT; i++)
            {
                sb.append(i + "," + i+"abc" + "\n");
                if (i % COMMIT_SIZE == 0)
                {
                    InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
                    ((com.mysql.jdbc.Statement) pstmt).setLocalInfileInputStream(is);
                    pstmt.execute();
                    conn.commit();
                    sb.setLength(0);
                }
            }
            InputStream is = new ByteArrayInputStream(sb.toString().getBytes());
            ((com.mysql.jdbc.Statement) pstmt).setLocalInfileInputStream(is);
            pstmt.execute();
            conn.commit();

            long endTime = System.currentTimeMillis();
            System.out.println("program runs " + (endTime - starTime) + "ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn.close();
        }
        //在最好的一行加上:
        System.out.println("\r插入数据条数："+COUNT+",提交的阀值："+COMMIT_SIZE+",执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");

    }


    public static void r(List<Fund> obs){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://"+"47.92.53.177:3306/houtai?useUnicode=true&characterEncoding=utf-8","root","root");
            // 关闭事务自动提交
            con.setAutoCommit(false);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
            TimeZone t = sdf.getTimeZone();
            t.setRawOffset(0);
            sdf.setTimeZone(t);
            Long startTime = System.currentTimeMillis();
            PreparedStatement pst=null;
            for (int i = 0; i < obs.size(); i++) {
                pst = (PreparedStatement) con.prepareStatement("insert into fund value("+obs.get(i)+",)");
                pst.setInt(1, i);
                // 把一个SQL命令加入命令列表
                pst.addBatch();
            }
            // 执行批量更新
            pst.executeBatch();
            // 语句执行完毕，提交本事务
            con.commit();
            Long endTime = System.currentTimeMillis();
            System.out.println("用时：" + sdf.format(new Date(endTime - startTime)));
            pst.close();
            con.close();
        }catch (Exception e){
            System.out.println("发生异常");
        }finally {

        }

    }



//    public void insertRecordTableq(List<Object[]> obs){
//        if(null != obs && !obs.isEmpty()){
//            String insertSql = "insert into product_check_company(id_uuid,column_name,oms,product,remark) values ";
//            StringBuffer sql = new StringBuffer();
//
//
//            for(int i = 0; i < obs.size(); i++){
//                sql.append("("+obs.get(i)[0]);
//                sql.append(",");
//                sql.append(obs.get(i)[1]);
//                sql.append(",");
//                sql.append(obs.get(i)[2]);
//                sql.append(",");
//                sql.append(obs.get(i)[3]);
//                sql.append(",");
//                sql.append(obs.get(i)[4]);
//                sql.append("),\n");
//            }
//
//            JdbcTemplate.update(insertSql+sql.toString().substring(0, sql.length() - 2));
//        }
//    }



}
