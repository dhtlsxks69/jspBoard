package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import repository.BoardRepository;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/update.jsp";
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardRepository br = new BoardRepository();
//		Board b = br.findByNum(num);
		
//		if(b != null){
//			request.setAttribute("board", b);
//		}
	}
	
}
