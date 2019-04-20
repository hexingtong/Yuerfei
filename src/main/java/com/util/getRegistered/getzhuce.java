package com.util.getRegistered;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class getzhuce {
    
    
    /**
     * @Author 苏俊杰
     * @Description //TODO list为日期list。begin将开始的日期传入，daySub为开始到结束日期之间的总天数，返回的是补全后的日期
     * @Date 17:07 2019/4/19
     * @Param [list, begin, daySub]
     * @return java.util.List<java.lang.String>
     **/
    public static List<String> completionDate(List<String> list , String begin , int daySub){
        ArrayList<String> dateResult = new ArrayList<String>();
        //时间增加一天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_MONTH, 1);
        String dateStr = sdf.format(yesterday.getTime());
        //日期比较(求差多少天)，时间也可以比较
        Calendar now = Calendar.getInstance();
        //字符串转化为时间
        Calendar calendar10 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        //循环处理日期数据，把缺失的日期补全。10是时间段内的天数,5是要处理的日期集合的天数
        try {
            Date date = sdf.parse(begin);
            calendar10.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(int curr = 0 ; curr < daySub ; curr++){
            boolean dbDataExist = false;
            int index = 0;
            for(int i  = 0 ; i < list.size() ; i++){
                try {
                    Date date2 = sdf.parse(list.get(i));
                    calendar5.setTime(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(calendar10.compareTo(calendar5) == 0){
                    dbDataExist  = true;
                    index = i;
                    break;
                }
            }
            if(dbDataExist){
                dateResult.add(list.get(index));
            }else{
                dateResult.add(sdf.format(calendar10.getTime()));
            }
            //还原calendar10
            calendar10.add(Calendar.DAY_OF_MONTH, 1 );
        }

        return dateResult;
    }






}
