package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.Board;
import repository.BoardRepository;

public class BoardWriteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("username : "+username);
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		
		//Board객체에 username, title, content 담기
		Board b = new Board();
		b.setUsername(username);
		b.setTitle(title);
		b.setContent(content);
		
		//모델(M)에 연결
		BoardRepository br = new BoardRepository();
		int result = br.save(b);
		
		//뷰(V)로 던져야 함.
		if(result == 1){
			response.sendRedirect("/board");
		}else{
			response.sendRedirect("/board/router?cmd=write");
		}
	}
	
}
