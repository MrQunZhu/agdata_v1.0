package org.clesun.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by clesun on 2017/5/17.
 */

public class ConfigUtils {

    static Logger log = LoggerFactory.getLogger(ConfigUtils.class);

    private static Properties prop = new Properties();
  /*  static {
        try {
            File file= FileUtils.getFileByFileName(ConstantCore.CONFIG_PROPS);
            log.debug(file.getPath());
            prop.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    public static boolean getBoolean(String name) {
        String value = prop.getProperty(name);
        return "1".equals(value) || "true".equalsIgnoreCase(value) || "t".equalsIgnoreCase(value);
    }

    public static int getInt(String name) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static int getInt(String name, int defaultValue) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    public static long getLong(String name) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Long.parseLong(value);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static long getLong(String name, long defaultValue) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Long.parseLong(value);
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    public static double getDouble(String name) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Double.parseDouble(value);
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static double getDouble(String name, double defaultValue) {
        String value = prop.getProperty(name);
        if (value != null) {
            try {
                return Double.parseDouble(value);
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    public static String getString(String name) {
        return prop.getProperty(name);
    }

    public static String getString(String name, String defaultValue) {
        String value = prop.getProperty(name);
        if (value != null) {
            return value.trim();
        }
        return defaultValue;
    }

    /**
     * @param name
     * @param defaultValue
     * @param regex 分隔符
     * @return
     * @author linsf
     */
    public static List<String> getStringList(String name, String defaultValue, String regex) {
        String value = prop.getProperty(name);
        if (value == null) {
            value=defaultValue;
        }
        List<String>list=new ArrayList<String>();
        String[] strs=value.toLowerCase().split(regex);
        if(null!=strs){
            for(String item:strs){
                list.add(item);
            }
        }
        return list;
    }


}

