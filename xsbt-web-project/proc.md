https://github.com/earldouglas/xsbt-web-plugin/blob/0.9/wiki/Home.md を参考にして試した。

ディレクトリの作成。

<pre>
[root@javacst001 xsbt-web-project]# mkdir project
[root@javacst001 xsbt-web-project]# mkdir -p src/main/scala
[root@javacst001 xsbt-web-project]# mkdir -p src/main/webapp/WEB-INF
</pre>

ファイルの作成。

<pre>
[root@javacst001 xsbt-web-project]# cat project/build.properties
sbt.version=0.13.0
[root@javacst001 xsbt-web-project]# cat src/main/webapp/WEB-INF/web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app
  xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
  version="2.5"
  >

  <servlet>
    <servlet-name>xwp template</servlet-name>
    <servlet-class>com.earldouglas.xwptemplate.XwpTemplateServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>xwp template</servlet-name>
    <url-pattern>/*</url-pattern>
  </servlet-mapping>

</web-app>
[root@javacst001 xsbt-web-project]# cat src/main/scala/XwpTemplateServlet.scala
package com.earldouglas.xwptemplate

import scala.xml.NodeSeq
import javax.servlet.http.HttpServlet

class XwpTemplateServlet extends HttpServlet {

  import javax.servlet.http.HttpServletRequest
  import javax.servlet.http.HttpServletResponse

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {

    response.setContentType("text/html")
    response.setCharacterEncoding("UTF-8")

    val responseBody: NodeSeq = <html><body><h1>Hello, world!</h1></body></html>
    response.getWriter.write(responseBody.toString)
  }
}
</pre>

アプリサーバー起動。

<pre>
[root@javacst001 xsbt-web-project]# sbt
Detected sbt version 0.13.0
Starting sbt: invoke with -help for other options
[info] Loading project definition from /root/dev/java/xsbt-web-project/project
[info] Set current project to xwp-template (in build file:/root/dev/java/xsbt-web-project/)
> container:start
2014-10-20 17:56:21.303:INFO:oejs.Server:pool-5-thread-4: jetty-9.1.0.v20131115
2014-10-20 17:56:21.493:INFO:oejw.StandardDescriptorProcessor:pool-5-thread-4: NO JSP Support for /, did not find org.apache.jasper.servlet.JspServlet
2014-10-20 17:56:21.515:INFO:oejsh.ContextHandler:pool-5-thread-4: Started o.e.j.w.WebAppContext@282b8861{/,[file:/root/dev/java/xsbt-web-project/src/main/webapp/],AVAILABLE}
2014-10-20 17:56:21.574:INFO:oejs.ServerConnector:pool-5-thread-4: Started ServerConnector@4af3011a{HTTP/1.1}{0.0.0.0:8080}
[success] Total time: 1 s, completed 2014/10/20 17:56:21
</pre>

動作確認。

<pre>
[root@javacst001 xsbt-web-project]# curl http://localhost:8080/; echo
<html><body><h1>Hello, world!</h1></body></html>
</pre>
