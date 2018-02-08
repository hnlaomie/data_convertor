package io.github.hnlaomie.csv;

import io.github.hnlaomie.csv.CSVRule;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public class RuleStorageImpl implements RuleStorage<CSVRule>, AutoCloseable {
    // singleton storage
    private static RuleStorage storage;
    // convertor map
    private Map<String, CSVRule> ruleMap;

    private RuleStorageImpl() {
        ruleMap = new HashMap<>();
    }

    public static synchronized RuleStorage getInstance() {
        if (storage == null) {
            storage = new RuleStorageImpl();
        }
        return storage;
    }

    @Override
    public CSVRule get(String key) {
        return ruleMap.get(key);
    }

    @Override
    public void add(String key, CSVRule rule) {
        if (rule != null) {
            ruleMap.put(key, rule);
        }
    }

    @Override
    public void remove(String key) {
        if (ruleMap.containsKey(key)) {
            ruleMap.remove(key);
        }
    }

    @Override
    public void close() {
        for (String key : ruleMap.keySet()) {
            remove(key);
        }
        ruleMap.clear();
    }
}

