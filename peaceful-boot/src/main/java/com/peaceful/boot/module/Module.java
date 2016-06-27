package com.peaceful.boot.module;

import com.peaceful.boot.common.chain.Command;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public abstract class Module {


    public String name;

    public Module(String name) {
        this.name = name;
    }

    /**
     * module载入
     *
     * @return true 继续向下加载 false 不加载后面的module
     */
    protected abstract boolean load();

    public abstract boolean close();

}
