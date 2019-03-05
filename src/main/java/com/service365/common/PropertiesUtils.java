package com.service365.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtils {


    private static Map<String, Properties> paths = new HashMap();
    private static Map<String, String> params = new HashMap();

    /**读取classPath 路径下的properties
     *             有相同key情况value 覆盖
     * @param fileName 读取classPath 路径下的properties
     *             有相同key情况value 覆盖
     */
    public static Properties loadProp(String fileName) {
        if (!paths.containsKey(fileName)) {
            Properties p = new Properties();
            try {
                p.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName));
            } catch (IOException e) {
//                throw new BaseRunTimeException("io 异常文件未找到",e);
            }
            Set<Object> set = p.keySet();
            for (Object s : set) {
                params.put(s.toString(), p.getProperty(s.toString()));
            }
            paths.put(fileName, p);
            return p;
        } else {
            return paths.get(fileName);
        }
    }

    public static String getProperty(String key) {
        return params.get(key);
    }

    public static void destroy() {
        params = null;
        paths = null;
    }
}
