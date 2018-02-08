package test;

import io.github.hnlaomie.csv.CSVRule;
import io.github.hnlaomie.csv.RuleLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.hnlaomie.common.util.exception.LogException;
import io.github.hnlaomie.common.constant.MessageID;
import io.github.hnlaomie.common.util.ExceptionUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public class Test {
    // 日志处理器
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        Test t = new Test();
        t.jsonTest();
    }

    public void logTest() {
        LogException e = ExceptionUtil.handle(MessageID.MSG_010002, new Exception("abc"));
        logger.info(e.toString());
    }

    public void jsonTest() {
        String lineSeparator = System.lineSeparator();
        String file = "/config/dsp/notify.json";

        try (InputStream in = getClass().getResourceAsStream(file);) {
            String source = new BufferedReader(new InputStreamReader(in))
                    .lines()
                    .parallel()
                    .collect(Collectors.joining(lineSeparator));
            CSVRule rule = RuleLoader.init(source);

            logger.info(rule.toString());
        } catch (IOException e) {
            logger.info(e.toString());
        } catch (LogException e) {
            logger.info(e.toString());
        }
    }
}
