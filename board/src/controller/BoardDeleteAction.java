package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import repository.BoardRepository;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board"; //자동으로 index.jsp 호출 -> /board/router?cmd=list
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		//모델연결
		BoardRepository br = new BoardRepository();
		int result = br.delete(num);
		
		//페이지로 이동
		if(result == 1){
			response.sendRedirect(url);
		}else{
			response.sendRedirect("/board/router?cmd=view&num="+num);
		}
	}
	
}
