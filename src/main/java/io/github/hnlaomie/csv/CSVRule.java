package io.github.hnlaomie.csv;

import io.github.hnlaomie.common.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public class CSVRule implements Serializable {
    // topic name
    private String topic;

    // csv input columns size
    private int inputSize;

    // csv column separator
    private String separator;

    // csv input columns
    private List<CSVColumn> inputColumns;

    // csv output columns
    private List<CSVColumn> outputColumns;

    public CSVRule() {
        this.inputColumns = new ArrayList<>();
        this.outputColumns = new ArrayList<>();
    }

    public List<CSVColumn> getInputColumns() {
        return inputColumns;
    }

    public void setInputColumns(List<CSVColumn> inputColumns) {
        this.inputColumns = inputColumns;
    }

    public List<CSVColumn> getOutputColumns() {
        return outputColumns;
    }

    public void setOutputColumns(List<CSVColumn> outputColumns) {
        this.outputColumns = outputColumns;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getInputSize() {
        return inputSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        /*
        this.inputColumns.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(","));
        */
        // StringUtils.join(this.inputColumns, ",")
        return ToStringBuilder.reflectionToString(this);
    }
}
