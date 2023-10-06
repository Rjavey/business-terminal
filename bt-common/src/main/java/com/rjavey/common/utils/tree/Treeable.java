package com.rjavey.common.utils.tree;

import java.util.List;


/**
 * @author rjavey
 */
public interface Treeable<T extends Treeable> {

    Object key();

    Object parentKey();

    T children(List<T> children);

    List<T> children();

    void add(T child);
}
