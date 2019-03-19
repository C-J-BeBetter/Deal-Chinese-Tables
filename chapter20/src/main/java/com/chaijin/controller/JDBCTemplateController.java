package com.chaijin.controller;

import com.chaijin.entity.UserTabColumns;
import com.chaijin.util.TanslateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

/**
 * @ProjectName: SpringBoot2-Learning
 * @Package: com.chaijin.controller
 * @ClassName: JDBCTemplateController
 * @Description:
 * @Author: 柴进
 * @Date: 2019/3/15 16:53
 * @Version: 1.0
 */
@RestController
public class JDBCTemplateController {
    private static final Logger log = LoggerFactory.getLogger(JDBCTemplateController.class);

    private static final String path = "D:\\CreateDemo\\";
    private static final String file_code = path + "code.txt";
    private static final String file_fun  = path + "fun.txt" ;

    private static final String[] tables = {
//            "DISK_复本文件信息表",
//            "DISK_附件下载日志",
//            "DISK_情报检索删除日志",
//            "DISK_情报检索上传日志",
//            "DISK_情报检索文件信息表",
//            "DISK_删除日志",
//            "DISK_上传服务器",
//            "DISK_上传日志",
//            "DISK_申请开通",
//            "DISK_文件命名规则",
//            "DISK_文件信息表",
//            "DISK_用户服务对应表",
//            "DISK_远程插盘日志",
//            "DISK_制作信息",
//            "DISK_浏览日志",
//            "ISBN出版者库",
//            "MARC处理日志",
//            "MARC过滤字段",
//            "MARC数据字典",
//            "MARC详细日志",
//            "MARC详细日志修改记录",
//            "OPAC_读者推荐库",
//            "OPAC_分类检索",
//            "OPAC_热门检索",
//            "OPAC_热门收藏",
//            "OPAC_文献评分",
//            "OPAC_文献评论",
//            "OPAC_资源连接",
//            "OPERN_封面",
//            "OPERN_服务器列表",
//            "OPERN_曲谱信息",
//            "OPERN_文件列表",
//            "XZ_公文库",
//            "XZ界面定义",
//            "Z39分组信息",
//            "Z39服务器信息",
//            "报表模板定义",
//            "报表模板定义NEW",
//            "标签打印临时表",
//            "标准书目源库",
//            "标准书目源库NEW",
//            "表格模板",
//            "采购经费库",
//            "采购库",
//            "采购批次号",
//            "操作员流通规则权限",
//            "查看馆藏地日志",
//            "查看验收状态日志",
//            "处罚类型",
//            "处罚信息",
//            "丛编库",
//            "待采书库NEW",
//            "单打标签库111",
//            "单打标签库112",
//            "单打标签库114",
//            "单打标签库NEW111",
//            "单打标签库NEW112",
//            "登录号工作分配表",
//            "典藏记录修改日志",
//            "读者操作日志",
//            "读者查询条件",
//            "读者单位",
//            "读者丢书赔款日志",
//            "读者库",
//            "读者特殊豁免日",
//            "读者特殊控制",
//            "读者统计",
//            "读者账号信息",
//            "发行商库",
//            "罚款信息",
//            "访问计数表",
//            "分类对应架位信息",
//            "分类馆藏统计",
//            "分类主题词表",
//            "附件信息表",
//            "馆藏地址定义",
//            "馆藏典藏库",
//            "馆藏明细",
//            "馆藏书目库",
//            "馆藏统计表",
//            "规范库",
//            "规范库MARC数据字典",
//            "规范库对应表",
//            "规范库检索途径定义",
//            "规范库一对多库",
//            "汉语拼音著者号码表",
//            "豁免日",
//            "机器",
//            "架位导航坐标",
//            "架位信息",
//            "检索编码库",
//            "检索途径定义",
//            "检索途径生成方式",
//            "检索一对多库",
//            "检索责任者库",
//            "检索主题词库",
//            "接送书库",
//            "接送书日志",
//            "借阅人次统计",
//            "金豆兑换库",
//            "金豆兑换日志",
//            "金豆信息日志",
//            "进货单时间段统计",
//            "拒采理由",
//            "课程表",
//            "课程读者推荐表",
//            "课程管理员推荐表",
//            "课程连接表",
//            "课程信息表",
//            "快速验收日志",
//            "流通参数定义",
//            "流通单位统计",
//            "流通分类统计",
//            "流通工作量统计",
//            "流通工作日",
//            "流通工作站定义",
//            "流通库",
//            "流通日志",
//            "流通条码修改日志",
//            "楼层布局图",
//            "年度增长表",
//            "盘点日志",
//            "赔书规则表",
//            "批量调配日志",
//            "批量验收表",
//            "批量验收登录号",
//            "拼音库",
//            "期刊采购分配库",
//            "期刊采购库",
//            "期刊催缺临时表",
//            "期刊订购比对表",
//            "期刊订购目录",
//            "期刊发行列表",
//            "期刊分配部门定义",
//            "期刊篇目库",
//            "期刊签到分配接收日志",
//            "期刊签到分配库",
//            "期刊签到库",
//            "期刊签到日志",
//            "期刊扫描日志",
//            "期刊预订订单号",
//            "期刊装订库",
//            "情报检索MARC数据字典",
//            "情报检索库",
//            "扫描分配日志",
//            "删除记录日志库",
//            "上架日志",
//            "审核日志",
//            "收费日志",
//            "收费项目",
//            "书目数据库定义",
//            "书目显示定义一",
//            "数据导入定义库",
//            "数据选择库",
//            "四角号码表",
//            "索书号重号管理",
//            "特借流通库",
//            "特殊借阅规则",
//            "特种统计表",
//            "条形码",
//            "停用读者网络",
//            "通知留言库",
//            "图书订购比对表",
//            "图书发行列表",
//            "图书赔偿分类统计",
//            "网页访问量",
//            "网页检索词库",
//            "违章处罚表",
//            "违章处罚对应关系",
//            "违章类型",
//            "委托借阅表",
//            "委托借阅规则",
//            "委托提出日志",
//            "文献传递表",
//            "文献传递日志",
//            "文献类型",
//            "文献流转库",
//            "文献流转日志",
//            "文献资源分类统计",
//            "系统参数定义",
//            "系统单位定义",
//            "系统定义",
//            "系统用户信息",
//            "下架日志",
//            "现刊条形码库",
//            "消息列表",
//            "消息模板",
//            "校区信息",
//            "新书征订单",
//            "新书征订规则",
//            "新书征订库",
//            "新书征订推荐库",
//            "新书征订消息",
//            "新书自动分配",
//            "虚拟库室",
//            "选书预分配规则",
//            "选书征订单",
//            "用户登录日志",
//            "预分配规则",
//            "预约库",
//            "远程访问登陆日志",
//            "阅览日志",
//            "阅览室定义",
//            "在架预约库",
//            "征订记录表",
//            "中图分类表",
//            "种次号库",
//            "种次号缺号库",
//            "自定义导出报表",
//            "自定义分类统计",
//            "自定义分类统计NEW",
//            "自定义著者号码表",
//            "综合借阅情况分类",
//            "综合借阅情况分类对应表",
              "总括登记表"
    };

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCTemplateController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public String queryUsers() {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();//创建一个新目录
        }
        FileWriter ps = null;
        BufferedWriter writer = null;

        FileWriter ps_fun = null;
        BufferedWriter writer_fun = null;
        try {
            ps = new FileWriter(file_code);
            writer = new BufferedWriter(ps);

            ps_fun = new FileWriter(file_fun);
            writer_fun = new BufferedWriter(ps_fun);

            for(int i = 0; i < tables.length; i++) {
                StringBuffer sb = new StringBuffer();
                StringBuffer sql_sb = new StringBuffer();
                //翻译后的英文表名
                String table = TanslateUtils.translateZH2EN(tables[i]);
                sb.append("#"+tables[i]);                                   //注解
                sb.append("\nfunction table_" + table + "(){");             //函数名
                sb.append("\n\thive_table_name=\""+table+"\"");             //hive_table_name
                sb.append("\n\tTABLE_COLUMNS=\"");                          //TABLE_COLUMNS:begin
                List<UserTabColumns> columns = getColumns(tables[i]);
                for(UserTabColumns s : columns){
                    String str = s.getColumnName();
                    String column = TanslateUtils.translateZH2EN(str);
                    sb.append("\n\t\t"+column+" STRING COMMENT \'"+str+"\'");
                    sql_sb.append("\n\t\t"+str+" AS c_"+column+",");            //sql语句的columns
                }
                sb.append("\n\t\"");                                        //TABLE_COLUMNS:end
                sb.append("\n\tSELECT_SQL=\"SELECT");                       //SQL:begin
                sb.append(sql_sb.substring(0,sql_sb.length()-1));           //sql语句的columns
                sb.append("\n\tFROM ${TABLE_PRE}"+tables[i]+" where 1=1\"");//SQL:end
                sb.append("\n\texec_sqoop_query \"$hive_table_name\" \"$TABLE_COLUMNS\" \"$SELECT_SQL\"");  //exec_sqoop_query
                sb.append("\n}");
                sb.append("\n");

                writer.append(sb.toString());
                writer_fun.append("\ttable_" + table + "\n");
                log.info("#######end: zh_tableName: "+ tables[i] +" - en_tableName: "+table);
            }
            writer.close();
            ps.close();

            writer_fun.close();
            ps_fun.close();
        } catch (IOException e) {
            log.error("#######写入信息发生错误！");
            e.printStackTrace();
        }
        return "代码写入文件成功\n"+path;
    }

    private List<UserTabColumns> getColumns(String table){
        String sql = "SELECT T.COLUMN_NAME AS columnName FROM USER_TAB_COLUMNS T " +
                "WHERE T.TABLE_NAME=?";
        List<UserTabColumns> columns = jdbcTemplate.query(sql, new Object[]{table}, new BeanPropertyRowMapper<>(UserTabColumns.class));
        return columns;
    }

}
