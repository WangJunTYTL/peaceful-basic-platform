package com.peaceful.boot.module;

import com.google.common.base.Throwables;
import com.google.common.collect.Sets;
import com.peaceful.boot.common.chain.BaseChain;
import com.peaceful.boot.common.chain.BaseContext;
import com.peaceful.boot.common.chain.Command;
import com.peaceful.boot.common.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * @author WangJun
 * @version 1.0 16/6/18
 */
public class ModuleList {

    private static BaseChain baseChain = new BaseChain();
    private static Context context = new BaseContext();
    private static int index;
    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleList.class);

    private synchronized static void load() {
        try {
            baseChain.execute(context);
        } catch (Exception e) {
            Throwables.propagate(e);
        }
    }

    public static synchronized void load(Module... modules) {
        for (Module module : modules) {
            add(module);
        }
        load();
    }

    public static Module getByName(String name) {
        return (Module) context.get(name);
    }

    public static synchronized void close(String... modules) {
        for (String module : modules) {
            Module m = (Module) context.remove(module);
            if (m != null) {
                m.close();
            }
        }
    }

    private static synchronized void add(final Module module) {
        baseChain.addCommand(new Command() {
            @Override
            public boolean execute(Context context) throws Exception {
                if (context.keySet().contains(module.name)) {
                    LOGGER.warn("{} had loaded ", module.name);
                    return true;
                } else {
                    LOGGER.debug("load module->{} order->{}", module.name, ++index);
                    context.put(module.name, module);
                    return module.load();
                }
            }
        });
    }

}
