package action;

import controller.BoardDeleteAction;
import controller.BoardListAction;
import controller.BoardUpdateAction;
import controller.BoardUpdateProcAction;
import controller.BoardViewAction;
import controller.BoardWriteAction;
import controller.BoardWriteProcAction;

//cmd값을 분기만 시키면 됨
public class BoardFactory {
	public static Action getAction(String cmd){
		if(cmd.equals("write")){
			return new BoardWriteAction();
		}else if(cmd.equals("writeProc")){
			return new BoardWriteProcAction();
		}else if(cmd.equals("update")){
			return new BoardUpdateAction();
		}else if(cmd.equals("updateProc")){
			return new BoardUpdateProcAction();
		}else if(cmd.equals("delete")){
			return new BoardDeleteAction();
		}else if(cmd.equals("view")){
			return new BoardViewAction();
		}else if(cmd.equals("list")){
			return new BoardListAction();
		}
		return null;
	}
}
