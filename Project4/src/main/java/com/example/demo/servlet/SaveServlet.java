package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//회원 등록 폼에서 입력된 정보를 받아 새로운 회원을 저장하는 서블릿 만들기

@WebServlet(name = "SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet {
	//회원정보를 관리할 리파지토리 생성
	MemberRepository repository = new MemberRepository();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//회원이름과 패스워드로 새로운 멤버 객체 생성
		Member member = new Member(0, username, password);
		
		//생성된 회원 객체를 저장소에 등록
		repository.save(member);
		
		//응답 메세지 설정(컨텐츠 타입과 문자 인코딩)
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		
		//등록 결과를 확인하기 위한 html을 만들어서 응답에 추가
        w.write("<html>\n" +
        "<head>\n" +
        " <meta charset=\"UTF-8\">\n" +
        "</head>\n" +
        "<body>\n" +
        "성공\n" +
        "<ul>\n" +
        " <li>회원번호="+member.getNo()+"</li>\n" +
        " <li>이름="+member.getUserId()+"</li>\n" +
        " <li>비밀번호="+member.getPassword()+"</li>\n" +
        "</ul>\n" +
        "</body>\n" +
        "</html>");
	}
	
}
