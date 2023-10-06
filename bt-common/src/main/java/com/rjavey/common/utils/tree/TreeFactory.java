package com.rjavey.common.utils.tree;


/**
 * @author rjavey
 */
public interface TreeFactory<I, O extends Treeable> {

    O convert(I i);

    O buildDefaultRoot();

}
