package com.qf.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Create by it_mck 2018/10/25 18:16
 *
 * @Description: 操作时间常用类
 * @Version: 1.0
 */
public class GetDateUtil {


    /**
     * 获取过去或者未来 任意天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> pastDay(int intervals ) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
            pastDaysList.add(getPastDate(i));
            Collections.sort(pastDaysList);
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        // Log.e(null, result);
        return result;
    }


    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     * @param beginDate yyyy-MM-dd
     * @param endDate yyyy-MM-dd
     * @return List<Date>
     * @throws ParseException
     */
    public static List<String> getDatesStr(String beginDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lDate = new ArrayList<String>();
        lDate.add(beginDate);//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(sdf.parse(beginDate));
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (sdf.parse(endDate).after(cal.getTime())) {
                lDate.add(sdf.format(cal.getTime()));
            } else {
                break;
            }
        }
        lDate.add(endDate);//把结束时间加入集合
        return lDate;
    }
    /**
     * 获取当月的第一天和最后一天
     * @return
     */
    public static Map<String,String> getFirstDayAndLastDay(){
        Map<String,String> map=new HashMap<String,String>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        map.put("firstDay", format.format(c.getTime()));
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        map.put("lastDay", format.format(ca.getTime()));
        return map;
    }
    /**
     * 获取一天内的开始结束时间 2018-08-16 00:00:00 ~ 2018-08-17 13:38:00
     * @return
     */
    public static Map<String,Date> getStartTimeAndEndTime(Date date){
        Map<String,Date> map=new HashMap<String,Date>();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date startTime = c.getTime();
        map.put("startTime", startTime);
        map.put("endTime", date);
        return map;
    }

    /**
     * main函数用于测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(pastDay(14));
    }
}
