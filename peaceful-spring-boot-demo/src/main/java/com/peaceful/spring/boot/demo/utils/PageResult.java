package com.peaceful.spring.boot.demo.utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageResult {

    private static VelocityEngine velocityEngine;

    public static void setVelocityEngine(VelocityEngine velocityEngine) {
        PageResult.velocityEngine = velocityEngine;
    }

    public static String render(String template, Map<String, Object> data) {
        VelocityContext context = new VelocityContext();
        data.forEach((k, v) -> context.put(k, v));
        Writer writer = new StringWriter();
        velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
        return writer.toString();
    }

}
