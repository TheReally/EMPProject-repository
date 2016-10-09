package cn.mldn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import cn.mldn.util.servlet.DispatcherServlet;
import cn.mldn.vo.Emp;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/EmpServlet/*")
public class EmpServlet extends DispatcherServlet {
	public String add() throws ServletException, IOException {
		// TODO Auto-generated method stub
		Emp vo = new Emp() ; 
		vo.setEmpno(Integer.parseInt(super.request.getParameter("empno")));
		vo.setEname(super.request.getParameter("ename"));
		vo.setSal(Double.parseDouble(super.request.getParameter("sal")));
		try { 
			vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(super.request.getParameter("hiredate"))); 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		System.out.println(vo);
		super.setUrlAndMsg("emp.add.page","vo.add.success.msg");
		return "forward.page";
	}
	public String edit() throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("edit");
		return "forward.page";
	}
	public String list() throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("remove");
		return "emp.list";
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "雇员";
	}

}
