package com.qf.manager.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create by it_mck 2018/10/19 17:28
 *
 * @Description:
 * @Version: 1.0
 */
public class KitUtil {
    public KitUtil() {
    }

    public static String hellow() {
        return "Hello openkit";
    }

    /**
     * md5加密
     * @param s 要加密的字符串
     * @return
     */
    public static String md5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for(int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return new String(str);
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }
    }

    /**
     *
     * 日期转字符串
     *
     * @param date 日期
     * @param type 字符串类型
     * @return
     * @throws Exception
     */
    public static String dataToString(Date date, String type) throws Exception {
        SimpleDateFormat simpleFormat = null;
        simpleFormat = getSimpleDateFormat(type);
        return simpleFormat.format(date);
    }

    /**
     *
     * 字符串类型转日期
     * @param string
     * @param type
     * @return
     * @throws Exception
     */
    public static Date stringToData(String string, String type) throws Exception {
        SimpleDateFormat simpleFormat = null;
        Date date = null;
        simpleFormat = getSimpleDateFormat(type);
        date = simpleFormat.parse(string);
        return date;
    }

    /**
     *
     * 获取随机数
     * @param type
     * @return
     */
    public static int randomNumber(int type) {
        if (type == 8) {
            return (int)((Math.random() * 9.0D + 1.0D) * 1.0E7D);
        } else if (type == 7) {
            return (int)((Math.random() * 9.0D + 1.0D) * 1000000.0D);
        } else if (type == 6) {
            return (int)((Math.random() * 9.0D + 1.0D) * 100000.0D);
        } else if (type == 5) {
            return (int)((Math.random() * 9.0D + 1.0D) * 10000.0D);
        } else if (type == 4) {
            return (int)((Math.random() * 9.0D + 1.0D) * 1000.0D);
        } else if (type == 3) {
            return (int)((Math.random() * 9.0D + 1.0D) * 100.0D);
        } else {
            return type == 2 ? (int)((Math.random() * 9.0D + 1.0D) * 10.0D) : (int)((Math.random() * 9.0D + 1.0D) * 100000.0D);
        }
    }

    /**
     *
     * 获取指定长度的随机字符串
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val = val + (char)(random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val = val + String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }

    /**
     * 时间差
     * @param start
     * @param end
     * @param type
     * @return
     */
    public static int timeDifference(Date start, Date end, int type) {
        int figure = 0;
        long from1 = start.getTime();
        long to1 = end.getTime();
        if (type == 1) {
            figure = (int)((to1 - from1) / 1000L);
        }

        if (type == 2) {
            figure = (int)((to1 - from1) / 60000L);
        }

        if (type == 3) {
            figure = (int)((to1 - from1) / 3600000L);
        }

        if (type == 4) {
            figure = (int)((to1 - from1) / 86400000L);
        }

        return figure;
    }

    public static Map<String, Object> returnMap(String code, String msg) {
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    /**
     *
     * 获取uuid字符串
     * @return
     */
    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    /**
     *
     * 随机字符串
     * @return
     */
    public static String getOrderCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int a = (int)(Math.random() * 9000.0D) + 1000;
       // System.out.println(a);
        Date date = new Date();
        String str = sdf.format(date);
        String[] split = str.split("-");
        String s = split[0] + split[1] + split[2];
        String[] split1 = s.split(" ");
        String s1 = split1[0] + split1[1];
        String[] split2 = s1.split(":");
        String s2 = split2[0] + split2[1] + split2[2] + a;
       // System.out.println(s2);
        return s2;
    }

    /**
     *
     * 获取指定类型日期
     * @param type
     * @return
     * @throws Exception
     */
    private static SimpleDateFormat getSimpleDateFormat(String type) throws Exception {
        SimpleDateFormat simpleFormat;
        if ("1".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        } else if ("2".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("3".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy/MM");
        } else if ("4".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyyMMdd");
        } else if ("5".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        } else if ("6".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        } else if ("7".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        } else if ("8".equals(type)) {
            simpleFormat = new SimpleDateFormat("HH:mm");
        } else if ("9".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else if ("10".equals(type)) {
            simpleFormat = new SimpleDateFormat("HH:mm");
        } else if ("11".equals(type)) {
            simpleFormat = new SimpleDateFormat("yyyy-MM");
        } else if (!"".equals(type) && type != null) {
            simpleFormat = new SimpleDateFormat(type);
        } else {
            simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        return simpleFormat;
    }

    public static String remove(String resource, char ch) {
        StringBuffer buffer = new StringBuffer();
        int position = 0;

        while(position < resource.length()) {
            char currentChar = resource.charAt(position++);
            if (currentChar != ch) {
                buffer.append(currentChar);
            }
        }

        return buffer.toString();
    }

    /**
     * 非空判断
     * @param string
     * @return
     */
    public static Boolean feikong(Object string) {
        return string != null && !"".equals(string) ? true : false;
    }

    public static Map<String, Object> isNull(Map<String, Object> map) {
        Iterator var1 = map.entrySet().iterator();

        Map.Entry entry;
        do {
            if (!var1.hasNext()) {
                return returnMap("200", "");
            }

            entry = (Map.Entry)var1.next();
            System.out.println("Key = " + (String)entry.getKey() + ", Value = " + entry.getValue());
        } while(entry.getValue() != null && !"".equals(entry.getValue()));

        return returnMap("300", "参数：" + (String)entry.getKey() + " 不能为空！");
    }

    /**
     * javaBean转Map
     * @param javaBean
     * @return
     */
    public static Map toMap(Object javaBean) {
        Map result = new HashMap();
        Method[] methods = javaBean.getClass().getDeclaredMethods();
        Method[] var3 = methods;
        int var4 = methods.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Method method = var3[var5];

            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[])null);
                    result.put(field, null == value ? "" : value.toString());
                }
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        }

        return result;
    }

    public static Map toMap(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;

        while(iterator.hasNext()) {
            key = (String)iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);
        }

        return result;
    }

    public static JSONObject toJSON(Object bean) {
        return new JSONObject(toMap(bean));
    }

    public static Object toJavaBean(Object javabean, Map data) {
        Method[] methods = javabean.getClass().getDeclaredMethods();
        Method[] var3 = methods;
        int var4 = methods.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Method method = var3[var5];

            try {
                if (method.getName().startsWith("set")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(javabean, data.get(field));
                }
            } catch (Exception var8) {
                ;
            }
        }

        return javabean;
    }

    public static Set<Integer> mathMinToMaxAndNum(int min, int max, int num) {
        HashSet set = new HashSet();

        do {
            set.add((int)(Math.random() * (double)(max - min) + (double)min + 1.0D));
        } while(set.size() != num);

        System.out.println(set);
        return set;
    }

    public static Boolean redPaper(int num, int number, int restHasNoMoney, float scale) {
        int hasMoney = (int)Math.floor((double)((float)num * scale));
        int hasNoMoney = num - hasMoney;
        int surplusHasNoMoney = hasNoMoney - restHasNoMoney;
        int surplusHasMoney = hasMoney - (number - 1 - restHasNoMoney);
        int surplusAll = num - number + 1;
        if (surplusHasNoMoney >= num - number + 1) {
            return false;
        } else if (surplusHasNoMoney == 0) {
            return true;
        } else {
            int i = (int)(Math.random() * (double)(surplusAll - 1) + 1.0D + 1.0D);
            return i <= surplusHasMoney ? true : false;
        }
    }


    public static void main(String[] args) {

        String mck = KitUtil.getOrderCode();
        System.out.println(mck);
    }
}

