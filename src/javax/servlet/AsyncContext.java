/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package javax.servlet;

/**
 * TODO SERVLET3 - Add comments
 * @since Servlet 3.0
 */
public interface AsyncContext {
    public static final String ASYNC_REQUEST_URI =
            "javax.servlet.async.request_uri";
    public static final String ASYNC_CONTEXT_PATH  =
            "javax.servlet.async.context_path";
    public static final String ASYNC_PATH_INFO =
            "javax.servlet.async.path_info";
    public static final String ASYNC_SERVLET_PATH =
            "javax.servlet.async.servlet_path";
    public static final String ASYNC_QUERY_STRING =
            "javax.servlet.async.query_string";

    ServletRequest getRequest();

    ServletResponse getResponse();

    boolean hasOriginalRequestAndResponse();

    /**
     * @throws IllegalStateException if this method is called when the request
     * is not in asynchronous mode. The request is in asynchronous mode after
     * {@link javax.servlet.http.HttpServletRequest#startAsync()} or
     * {@link javax.servlet.http.HttpServletRequest#startAsync(ServletRequest,
     * ServletResponse)} has been called and before {@link #complete()} or any
     * other dispatch() method has been called.
     */
    void dispatch();

    /**
     * @param path The path to which the request/response should be dispatched
     *             relative to the {@link ServletContext} from which this async
     *             request was started.
     *
     * @throws IllegalStateException if this method is called when the request
     * is not in asynchronous mode. The request is in asynchronous mode after
     * {@link javax.servlet.http.HttpServletRequest#startAsync()} or
     * {@link javax.servlet.http.HttpServletRequest#startAsync(ServletRequest,
     * ServletResponse)} has been called and before {@link #complete()} or any
     * other dispatch() method has been called.
     */
    void dispatch(String path);

    /**
     * @param path The path to which the request/response should be dispatched
     *             relative to the specified {@link ServletContext}.
     * @param context The {@link ServletContext} to which the request/response
     *                should be dispatched.
     *
     * @throws IllegalStateException if this method is called when the request
     * is not in asynchronous mode. The request is in asynchronous mode after
     * {@link javax.servlet.http.HttpServletRequest#startAsync()} or
     * {@link javax.servlet.http.HttpServletRequest#startAsync(ServletRequest,
     * ServletResponse)} has been called and before {@link #complete()} or any
     * other dispatch() method has been called.
     */
    void dispatch(ServletContext context, String path);

    void complete();

    void start(Runnable run);

    void addListener(AsyncListener listener);

    void addListener(AsyncListener listener, ServletRequest request,
                     ServletResponse response);

    <T extends AsyncListener> T createListener(Class<T> clazz)
    throws ServletException;

    /**
     * Set the timeout.
     *
     * @param timeout The timeout in milliseconds. 0 or less indicates no
     *                timeout.
     */
    void setTimeout(long timeout);

    /**
     * Get the current timeout.
     *
     * @return The timeout in milliseconds. 0 or less indicates no timeout.
     */
    long getTimeout();
}
