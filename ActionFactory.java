package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import com.exam.controller.board.ContentAction;
import com.exam.controller.board.DeleteAction;
import com.exam.controller.board.DeleteFormAction;
import com.exam.controller.board.FileContentAction;
import com.exam.controller.board.FileDeleteAction;
import com.exam.controller.board.FileNoticeAction;
import com.exam.controller.board.FileUpdateAction;
import com.exam.controller.board.FileUpdateFormAction;
import com.exam.controller.board.FileWriteAction;
import com.exam.controller.board.FileWriteFormAction;
import com.exam.controller.board.NoticeAction;
import com.exam.controller.board.ReWriteAction;
import com.exam.controller.board.UpdateAction;
import com.exam.controller.board.UpdateFormAction;
import com.exam.controller.board.WriteAction;
import com.exam.controller.board.WriteFormAction;
import com.exam.controller.board.reWriteFormAction;
import com.exam.controller.member.Historyaction;
import com.exam.controller.member.JoinIdDupCheckAction;
import com.exam.controller.member.JoinIdDupCheckJsonAction;
import com.exam.controller.member.MainAction;
import com.exam.controller.member.MemberJoinAction;
import com.exam.controller.member.MemberJoinFormAction;
import com.exam.controller.member.MemberLoginAction;
import com.exam.controller.member.MemberLoginFormAction;
import com.exam.controller.member.MemberLogoutAction;
import com.exam.controller.member.WelcomeAction;

public class ActionFactory {
	
	private Map<String, Action> map = new HashMap<String, Action>();
	
	private static ActionFactory instance = new ActionFactory();
		
	public static ActionFactory getInstance() {
		return instance;
	}

	private ActionFactory() {
		// 생성자에서 미리 컨트롤러(Action클래스) 등록하기
		
		// member 명령어 관련 Action 객체 등록
		map.put("/memberJoinForm.do", new MemberJoinFormAction());
		map.put("/memberJoin.do", new MemberJoinAction());
		map.put("/memberLoginForm.do", new MemberLoginFormAction());
		map.put("/memberLogin.do", new MemberLoginAction());
		map.put("/main.do", new MainAction());
		map.put("/memberLogout.do", new MemberLogoutAction());
		// 아이디 중복확인
		map.put("/joinIdDupCheck.do", new JoinIdDupCheckAction());
		// 아이디 중복확인 Ajax 방식
		map.put("/joinIdDupCheckJson.do", new JoinIdDupCheckJsonAction());
		// company 명령어 관련 Action 객체 등록
		map.put("/welcome.do", new WelcomeAction()); // views 폴더는 WEB - INF 폴더안에 숨어있기에
		map.put("/history.do", new Historyaction()); // CSS가 깨질경우 jsp파일 경로를 새로 지정해준다. (ex ../ 상위경로 삭제해주면됨.)
		
		// =====================================
		
		// board 명령어 관련 Action 객체 등록
		map.put("/notice.do", new NoticeAction());
		map.put("/fnotice.do", new FileNoticeAction());
		// 게시글 작성 관련 Action 객체 등록
		map.put("/writeForm.do", new WriteFormAction());
		map.put("/write.do", new WriteAction());
		map.put("/fwriteForm.do", new FileWriteFormAction());
		map.put("/fwrite.do", new FileWriteAction());
		// 컨텐츠 화면 관련 Action 객체
		map.put("/content.do", new ContentAction());
		map.put("/fcontent.do", new FileContentAction());
		// 게시글 수정 관련 Action 객체 등록
		map.put("/updateForm.do", new UpdateFormAction());
		map.put("/update.do", new UpdateAction());
		map.put("/fupdateForm.do", new FileUpdateFormAction());
		map.put("/fupdate.do", new FileUpdateAction());
		// 게시글 삭제 관련 Action 객체 등록
		map.put("/deleteForm.do", new DeleteFormAction());
		map.put("/delete.do", new DeleteAction());
		map.put("/fdelete.do", new FileDeleteAction());
		// 게시글 답글 관련 Action 객체 등록
		map.put("/reWriteForm.do",new reWriteFormAction());
		map.put("/reWrite.do", new ReWriteAction());
		
		
	} // 생성자

	
	public Action getAction(String command) {
		Action action = map.get(command);
		return action;
	} // getAction method
	
}
