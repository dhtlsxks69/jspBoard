package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.Board;
import model.Reply;
import repository.BoardRepository;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/view.jsp";
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		//모델에 연결
		BoardRepository br = new BoardRepository();
		Board b = br.findByNum(num);
		List<Reply> replys = br.findByBoardId(num);
		
		if(replys != null){
			request.setAttribute("replys", replys);
		}
		
		//페이지 이동!!
		if(b != null){
			request.setAttribute("board", b);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else{
			response.sendRedirect("/board");
		}
	}
	
}
