package com.panie.common.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MybatisConfigAutoGen
{
    
    public static String jdbcDriver = "com.mysql.jdbc.Driver";
    public static String jdbcUrl = "jdbc:mysql://localhost:3306/blogdb";
    public static String jdbcUser = "root";
    public static String jdbcPassword = "123456";
    public static String newline = "\r\n";
    public static String tableKey = "cms_";
    
    public static String driverJar = "mysql-connector-java-5.1.38.jar";// 所使用驱动包
    
    public static String entityPkg = "com.panie.modules.cms.entity";
    public static String mappingPkg = "mappings.com.panie.modules.configure";
    public static String daoPkg = "com.panie.modules.cms.dao";
    
    public static String genConfig()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(newline);
        sb.append(
            "<!DOCTYPE generatorConfiguration  PUBLIC \"-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN\" ")
            .append(newline);
        sb.append("\"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd\"> ").append(newline);
        sb.append("<generatorConfiguration>").append(newline);
        sb.append("    <classPathEntry  location=\"").append(driverJar).append("\"/> ").append(newline);
        sb.append("    <context id=\"DB2Tables\"  targetRuntime=\"MyBatis3\">").append(newline);
        sb.append("        <commentGenerator>").append(newline);
        sb.append("            <property name=\"suppressDate\" value=\"true\"/>").append(newline);
        sb.append("            <property name=\"suppressAllComments\" value=\"true\"/> ").append(newline);
        sb.append("        </commentGenerator>").append(newline);
        sb.append("        <jdbcConnection driverClass=\"")
            .append(jdbcDriver)
            .append("\" connectionURL=\"")
            .append(jdbcUrl)
            .append("\" userId=\"")
            .append(jdbcUser)
            .append("\" password=\"")
            .append(jdbcPassword)
            .append("\"> ")
            .append(newline);
        sb.append("        </jdbcConnection>").append(newline);
        sb.append("       <javaTypeResolver>   ").append(newline);
        sb.append("            <property name=\"forceBigDecimals\" value=\"false\"/> ").append(newline);
        sb.append("        </javaTypeResolver>").append(newline);
        sb.append("        <javaModelGenerator targetPackage=\"")
            .append(entityPkg)
            .append("\" targetProject=\"src\">  ")
            .append(newline);
        sb.append("            <property name=\"enableSubPackages\" value=\"true\"/>  ").append(newline);
        sb.append("            <property name=\"trimStrings\" value=\"true\"/>").append(newline);
        sb.append("        </javaModelGenerator> ").append(newline);
        sb.append("        <sqlMapGenerator targetPackage=\"")
            .append(mappingPkg)
            .append("\" targetProject=\"src\">")
            .append(newline);
        sb.append("            <property name=\"enableSubPackages\" value=\"true\"/>").append(newline);
        sb.append("        </sqlMapGenerator>").append(newline);
        sb.append("        <javaClientGenerator type=\"XMLMAPPER\" targetPackage=\"")
            .append(daoPkg)
            .append("\" targetProject=\"src\"> ")
            .append(newline);
        sb.append("            <property name=\"enableSubPackages\" value=\"true\"/> ").append(newline);
        sb.append("        </javaClientGenerator>  ").append(newline);
        sb.append(genDbTable()).append(newline);
        sb.append("    </context>").append(newline);
        
        sb.append("</generatorConfiguration>").append(newline);
        return sb.toString();
        
    }
    
    public static String genDbTable()
    {
        
        StringBuilder sb = new StringBuilder();
        Connection conn = null;
        try
        {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            DatabaseMetaData metadata = conn.getMetaData();
            ResultSet res = metadata.getTables("blogdb", null, null, null);
            while (res.next())
            {
                String tablename = res.getString(3);
                String tabletype = res.getString(4);
                if (tabletype.equals("TABLE") && tablename.toLowerCase().indexOf(tableKey) != -1)
                {
                    sb.append("<table tableName=\"");
                    sb.append(tablename);
                    sb.append("\" domainObjectName=\"");
                    sb.append(StringUtils.toCapitalizeCamelCase(tablename));
                    sb.append(
                        "\" enableCountByExample=\"false\" enableUpdateByExample=\"false\" enableDeleteByExample=\"false\" enableSelectByExample=\"false\" selectByExampleQueryId=\"false\"></table>")
                        .append(newline);
                    
                }
            }
            
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        return sb.toString();
        
    }
    
    public static void main(String[] args)
    {
        System.out.println(genConfig());
    }
}
