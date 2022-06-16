package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;

		
		//방명록 리스트
		public List<GuestbookVo> getGuestList() {
			List<GuestbookVo> guestList = sqlSession.selectList("guestbook.selectList");			
			System.out.println("guestList: "+guestList);
			return guestList;
		}
		

		//방명록 등록
		public void guestbookInsert(GuestbookVo guestbookVo) {
			System.out.println("guestbookVo: "+guestbookVo);
			sqlSession.insert("guestbook.guestbookInsert", guestbookVo);
		}


		//방명록 정보 가져오기(방명록 삭제 폼- 삭제할 방명록 정보 확인) no name password content reg_date
		public GuestbookVo getGuest(int no) {
			System.out.println("no: "+no);
			GuestbookVo guestVo = sqlSession.selectOne("guestbook.getGuest", no);
			
			return guestVo;
		}
		

		//방명록 작성자 정보 가져오기(비밀번호 확인용)
		public GuestbookVo checkGuest(GuestbookVo guestbookVo) {
			System.out.println("guestbookVo: "+guestbookVo);
			
			GuestbookVo guestVo = sqlSession.selectOne("guestbook.checkGuest", guestbookVo);
			System.out.println(guestVo+"삭제용");
			
			return guestVo;
		}
		

		//방명록 삭제
		public void guestbookDelete(GuestbookVo guestbookVo) {
			System.out.println("guestbookVo: "+guestbookVo);
			sqlSession.delete("guestbook.guestbookDelete", guestbookVo);
		}
		
}		