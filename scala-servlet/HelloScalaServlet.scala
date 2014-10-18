import javax.servlet.http.{HttpServlet,
  HttpServletRequest => HSReq, HttpServletResponse => HSResp}

class HelloScalaServlet extends HttpServlet
{
  override def doGet(req : HSReq, resp : HSResp) =
    resp.getWriter().print("<HTML>" +
      "<HEAD><TITLE>Hello, Scala!</TITLE></HEAD>" +
      "<BODY>Hello, Scala! This is a servlet.</BODY>" +
      "</HTML>")
}
