package com.peaceful.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Date 14/10/21.
 * Author WangJun
 * Email wangjuntytl@163.com
 * <p/>
 * <h2>常用http对象</h2>
 * <p>需要配置httpContextFilter,可以从线程上下文拿到request和response对象</p>
 *
 */
public class Http {


    /**
     * 获得HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return HttpContext.requestThreadLocal.get();
    }

    static void setRequest(HttpServletRequest request) {
        HttpContext.requestThreadLocal.set(request);
    }

    /**
     * 获得HttpServletResponse
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return HttpContext.responseThreadLocal.get();
    }

    static void setResponse(HttpServletResponse response) {
        HttpContext.responseThreadLocal.set(response);
    }


    /**
     * getRequest().getAttribute(key);
     *
     * @param key
     * @return
     */
    public static Object param(String key) {
        return getRequest().getAttribute(key);
    }

    /**
     * getRequest().setAttribute(key, value);
     *
     * @param key
     * @param value
     */
    public static void param(String key, Object value) {
        getRequest().setAttribute(key, value);
    }

    public static String getCookie(String key, String path) {
        if (key == null)
            return null;
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (path == null || path.equals("/")) {
                    if (key.equals(cookie.getName()) && (StringUtils.isEmpty(cookie.getPath()) || cookie.getPath().equals("/"))) {
                        return cookie.getValue();
                    }
                } else {
                    if (key.equals(cookie.getName()) && cookie.getPath() != null && cookie.getPath().equals(path)) {
                        String value = cookie.getValue();
                        if (StringUtils.isNotEmpty(value))
                            return value;
                    }
                }

            }
        }
        return null;
    }

    /**
     * 在当前路径下放入cookie
     *
     * @param key
     * @param value
     */
    public static void addCookie(String key, String value) {
        addCookie(key, value, null, -1, false);
    }

    /**
     * 在指定路径下放入cookie
     *
     * @param key
     * @param value
     * @param path
     */
    public static void addCookie(String key, String value, String path) {
        addCookie(key, value, path, -1, false);
    }

    /**
     * 可有选择性的加入cookie
     *
     * @param key
     * @param value
     * @param path
     * @param expire
     */
    public static void addCookie(String key, String value, String path, int expire, boolean httpOnly) {
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName()) && cookie.getPath() != null && cookie.getPath().equals(getRequest().getRequestURI())) {
                    cookie.setValue(value);
                    if (path != null)
                        cookie.setPath(path);
                    cookie.setHttpOnly(httpOnly);
                    cookie.setMaxAge(expire);
                    getResponse().addCookie(cookie);
                    return;
                }
            }
        }
        javax.servlet.http.Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(expire);
        cookie.setHttpOnly(httpOnly);
        if (path != null)
            cookie.setPath(path);
        getResponse().addCookie(cookie);
    }

    /**
     * 删除当前路径为key的cookie
     *
     * @param key
     */
    public static void deleteCookie(String key) {
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName()) && cookie.getPath() != null && cookie.getPath().equals(getRequest().getRequestURI())) {
                    cookie.setMaxAge(0);
                    getResponse().addCookie(cookie);
                }
            }
        }
    }


    private static class HttpContext {
        static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();
        static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

    }

    /**
     * 常用的最简单json数据返回 格式：{"code":1,"result","suc"}
     * 请注意：该方法会向浏览器端响应数据，但不会自动终止其下面的代码继续执行
     *
     * @param code   返回状态码
     * @param result 返回详细信息
     */
    public static void responseJSON(int code, String result) {
        responseString(JSON.toJSONString(new ResponseFormat(code, result)));
    }

    public static void responseJSON(String msg) {
        responseString(msg);
    }

    public static void responseJSON(Object o){
        responseString(JSON.toJSONString(o));
    }


    public static void responseJSON(JSONObject jsonObject) {
        responseString(jsonObject.toJSONString());
    }

    private static void responseString(String str) {
        HttpServletResponse response = getResponse();
        try {
            response.setContentType("text/html;charset=UTF-8");
//            response.setContentType("text/json;charset=UTF-8"); // 浏览器直接访问会被要求下载，但jquery得到的直接就是json对象，不需要JSON.parse
            PrintWriter writer = response.getWriter();
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



