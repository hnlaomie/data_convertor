package io.github.hnlaomie.csv;

/**
 * Convertor storage interface, get Convertor by topic name.
 * @author <a href="mailto:laomie@163.com">laomie</a>
 * @date 2018/02/07
 */
public interface RuleStorage<E> {
    /**
     * add rule to storage for special topic
     * @param key topic
     * @param e rule bean
     */
    public void add(String key, E e);

    /**
     * get topic's rule
     * @param key topic
     * @return rule bean
     */
    public E get(String key);

    /**
     * remove topic's rule
     * @param key topic
     */
    public void remove(String key);
}

