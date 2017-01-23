package com.panie.common.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;

import com.panie.common.utils.PropertiesLoader;
import com.panie.common.utils.StringUtils;

/**
 * 全局配置类 注：当需要从配置文件读取值，或者整个项目都需要使用时，请在此类中添加新变量
 */
public class Global
{
    
    /**
     * 当前对象实例
     */
    private static Global global = new Global();
    
    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();
    
    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("conf.properties");
    
    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";
    
    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";
    
    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    
    /**
     * 获取当前对象实例
     */
    public static Global getInstance()
    {
        return global;
    }
    
    /**
     * 获取配置
     * 
     * @see ${fns:getConfig('adminPath')}
     */
    public static String getConfig(String key)
    {
        String value = map.get(key);
        if (value == null)
        {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }
    
    /**
     * 获取工程路径
     * 
     * @return
     */
    public static String getProjectPath()
    {
        // 如果配置了工程路径，则直接返回，否则自动获取。
        String projectPath = Global.getConfig("projectPath");
        if (StringUtils.isNotBlank(projectPath))
        {
            return projectPath;
        }
        try
        {
            File file = new DefaultResourceLoader().getResource("").getFile();
            if (file != null)
            {
                while (true)
                {
                    File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
                    if (f == null || f.exists())
                    {
                        break;
                    }
                    if (file.getParentFile() != null)
                    {
                        file = file.getParentFile();
                    }
                    else
                    {
                        break;
                    }
                }
                projectPath = file.toString();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return projectPath;
    }
    
}
