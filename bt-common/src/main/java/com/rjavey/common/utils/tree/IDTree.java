package com.rjavey.common.utils.tree;


/**
 * @author rjavey
 */
public abstract class IDTree<T extends Treeable> extends AbstractTree<T> {
    @Override
    public Object key() {
        return getId();
    }

    @Override
    public Object parentKey() {
        return getParentId();
    }

    public abstract Long getId();

    public abstract Long getParentId();

}
