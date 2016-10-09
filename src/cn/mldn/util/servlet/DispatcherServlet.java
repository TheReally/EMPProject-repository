package cn.mldn.util.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public abstract class DispatcherServlet extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private ResourceBundle pageResource;
	private ResourceBundle messageResource;
	public void init()throws ServletException{
		this.pageResource = ResourceBundle.getBundle("Pages",Locale.getDefault());
		this.messageResource = ResourceBundle.getBundle("Messages",Locale.getDefault());
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.request = request;
		this.response = response;
		String urlPage = "error.page";
		String uri = request.getRequestURI();
		String status = uri.substring(uri.lastIndexOf("/")+1);
		if(status!=null){
			try {
				Method method = this.getClass().getMethod(status);
				urlPage = method.invoke(this).toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.getRequestDispatcher(this.getPageValue(urlPage)).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	public void setUrlAndMsg(String pageKey,String messageKey){
		this.request.setAttribute("url", this.getPageValue(pageKey));
		if(this.getType()==null||"".equals(this.getType())){
			this.request.setAttribute("msg", this.getMessageValue(messageKey));
		}else{
			this.request.setAttribute("msg", MessageFormat.format(this.getMessageValue(messageKey),this.getType()));
		}
	}
	public String getPageValue(String pageKey){
		return this.pageResource.getString(pageKey);
	}
	public String getMessageValue(String messageKey){
		return this.messageResource.getString(messageKey);
	}
	public abstract String getType();
}
