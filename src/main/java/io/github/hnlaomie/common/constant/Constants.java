package io.github.hnlaomie.common.constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 常量定义
 *
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018.02.07
 */
public interface Constants {
    // 文件编码
    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final String ENCODING = "UTF-8";

    // 版本号
    public static final long SERIAL_VERSION_ID = 1;

    // 资源文件路径
    public static final String RESOURCE_KEY = "configPath";

    public static final String MSG_CONFIG_FILE = "config.log_messages";

    // 日志里异常标题
    public static final String EXCEPTION_HEADER = "BI异常：";

    // 日期显示格式
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    // csv的json名称
    public static final String CSV_TOPIC = "topic";
    public static final String CSV_INPUT_SIZE = "input_size";
    public static final String CSV_SEPARATOR = "separator";
    public static final String CSV_INPUT = "input";
    public static final String CSV_OUTPUT = "output";
    public static final String CSV_COLUMNS = "columns";
    public static final String CSV_INDEX = "index";
    public static final String CSV_NAME = "name";
    public static final String CSV_TYPE = "type";
    public static final String CSV_EXPRESSION = "expression";

    // csv column value type
    public static final String TYPE_STRING = "String";
}