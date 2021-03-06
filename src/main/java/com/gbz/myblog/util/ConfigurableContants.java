package com.gbz.myblog.util;


import java.io.IOException;  
import java.io.InputStream;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.HashSet;  
import java.util.Properties;  
import java.util.Set;  
  
 import org.apache.log4j.Logger;  
   
 /** 
  * 常量配置类，从指定文件读取常量 
  *  
  */  
 public class ConfigurableContants {  
   
     private static final Logger logger = Logger.getLogger(ConfigurableContants.class);  
   
     protected static Properties p = new Properties();  
   
     protected static void init(String propertyFileName) {  
         InputStream in = null;  
         try {  
             in = ConfigurableContants.class.getResourceAsStream(propertyFileName);  
             if (in != null)  
                 p.load(in);  
         } catch (IOException e) {  
             logger.error("load " + propertyFileName + " into Contants error");  
         } finally {  
             if (in != null) {  
                 try {  
                     in.close();  
                 } catch (IOException e) {  
                 }  
             }  
         }  
     }  
   
     protected static String getProperty(String key, String defaultValue) {  
         return p.getProperty(key, defaultValue);  
     }  
   
     protected static String getProperty(String key) {  
         return getProperty(key, "");  
     }  
   
     /** 
      * 取以","分割的集合属性 
      * 
      * @param key 
      * @param defaultValue 
      * @return 
      */  
     protected static Set<String> getSetProperty(String key, String defaultValue) {  
   
         String[] strings = p.getProperty(key, defaultValue).split(",");  
         HashSet<String> hashSet = new HashSet<String>(strings.length);  
         for (String string : strings) {  
             hashSet.add(string.trim());  
         }  
         return hashSet;  
     }  
   
     protected static Set<String> getSetProperty(String key) {  
         return getSetProperty(key, "");  
     }  
   
     protected static Date getPropertyWithDateFormate(String key, String dateFormate) {  
         String str = null;  
         Date date = null;  
         try {  
             str = getProperty(key, "");  
             date = new SimpleDateFormat(dateFormate).parse(str);  
         } catch (ParseException e) {  
             logger.error("Data [" + str + "] Error in Contants");  
         }  
         return date;  
     }  
 }  
