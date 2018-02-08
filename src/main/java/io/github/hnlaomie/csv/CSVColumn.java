package io.github.hnlaomie.csv;

import io.github.hnlaomie.common.constant.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public class CSVColumn implements Serializable {
    // array data index
    private int index;

    // name of column
    private String name;

    // type of column
    private String type;

    // expression for column
    private String expression;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
