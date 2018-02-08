package io.github.hnlaomie.csv;

import io.github.hnlaomie.common.constant.Constants;
import io.github.hnlaomie.common.constant.MessageID;
import io.github.hnlaomie.common.util.ExceptionUtil;
import io.github.hnlaomie.common.util.exception.LogException;
import io.github.hnlaomie.csv.CSVColumn;
import io.github.hnlaomie.csv.CSVRule;
import me.doubledutch.lazyjson.LazyArray;
import me.doubledutch.lazyjson.LazyObject;

import java.util.ArrayList;
import java.util.List;

/**
 * load csv rule from json string
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public class RuleLoader {
    /**
     * init rule from json string
     * @param json
     * @return
     */
    public static CSVRule init(String json) {
        CSVRule rule = new CSVRule();

        LazyObject root = new LazyObject(json);
        try {
            // topic
            String topic = root.getString(Constants.CSV_TOPIC);

            // input size
            int inputSize = root.getInt(Constants.CSV_INPUT_SIZE);

            // input
            LazyObject inputNode = root.getJSONObject(Constants.CSV_INPUT);
            LazyArray inputColumns = inputNode.getJSONArray(Constants.CSV_COLUMNS);
            List<CSVColumn> inputList = toList(inputColumns);

            // output
            LazyObject outputNode = root.getJSONObject(Constants.CSV_OUTPUT);
            LazyArray outputColumns = outputNode.getJSONArray(Constants.CSV_COLUMNS);
            List<CSVColumn> outputList = toList(outputColumns);

            rule.setTopic(topic);
            rule.setInputSize(inputSize);
            rule.setInputColumns(inputList);
            rule.setOutputColumns(outputList);
        } catch (Exception e) {
            String[] params = {json};
            LogException exp = ExceptionUtil.handle(MessageID.MSG_010003, params, e);
            throw exp;
        }
        return rule;

    }

    /**
     * convert json object to bean
     * @param columns
     * @return
     */
    private static List<CSVColumn> toList(LazyArray columns) {
        List<CSVColumn> columnList = new ArrayList<>();

        int columnSize = columns.length();
        for (int i = 0; i < columnSize; i++) {
            LazyObject column = columns.getJSONObject(i);

            String name = column.getString(Constants.CSV_NAME);
            // default type is string
            String type = column.isNull(Constants.CSV_TYPE)
                    ? Constants.TYPE_STRING : column.getString(Constants.CSV_TYPE);
            //String expression = column.isNull(Constants.CSV_EXPRESSION)
            //        ? null : column.getString(Constants.CSV_EXPRESSION);
            String expression = column.getString(Constants.CSV_EXPRESSION);
            // default index is array position
            int index = column.isNull(Constants.CSV_INDEX)
                    ? i : column.getInt(Constants.CSV_INDEX);

            CSVColumn csvColumn = new CSVColumn();
            csvColumn.setName(name);
            csvColumn.setType(type);
            csvColumn.setExpression(expression);
            csvColumn.setIndex(index);

            columnList.add(csvColumn);
        }

        return columnList;
    }
}

