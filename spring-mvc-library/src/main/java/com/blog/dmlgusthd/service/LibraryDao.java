package com.blog.dmlgusthd.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryDao {
	private final String NS="com.blog.dmlgusthd.Mapper.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertMember(Member member){
		return sqlSession.insert(NS+"insertMember",member);
	}
	
	public int insertBook(BManagement bm){
		return sqlSession.insert(NS+"insertBook",bm);
	}
	
	public int insertRent(BRent br){
		return sqlSession.insert(NS+"insertRent",br);
	}
	
	public int bookCheck(){
		return sqlSession.update(NS+"bookCheck");
	}
	
	public int deleteRent(String bmName){
		return sqlSession.delete(NS+"deleteRent", bmName);
	}
	
	public int updateManagement(String bmName){
		return sqlSession.delete(NS+"updateManagement",bmName);
	}
	
	public int updateInfo(Map<String, Object> map){
		return sqlSession.update(NS+"updateInfo",map);
	}
	
	public int pay(String bmName){
		return sqlSession.selectOne(NS+"pay",bmName);
	}
	
	public int day(String bmName){
		return sqlSession.selectOne(NS+"day",bmName);
	}
	
	public BRent selectRentInfo(String bmName){
		return sqlSession.selectOne(NS+"selectRentInfo",bmName);
	}
	
	public int insertInfo(BRent br){
		return sqlSession.insert(NS+"insertInfo",br);
	}
	
	public Member selectOneMember(int mNo){
		return sqlSession.selectOne(NS+"selectOneMember",mNo);
	}
	
	public int updateMember(Member member){
		return sqlSession.update(NS+"updateMember",member);
	}
	
	public int deleteMember(int mNo){
		return sqlSession.delete(NS+"deleteMember",mNo);
	}
	
	public List<Member> selectMember(Map<String, Integer>map){
		return sqlSession.selectList(NS+"selectMember",map);
	}
	
	public int selectTotalMemberCount(){
		return sqlSession.selectOne(NS+"selectTotalMemberCount");
	}
	
	public List<BManagement> selectBook(Map<String, Integer>map){
		return sqlSession.selectList(NS+"selectBook",map);
	}
	
	public int selectTotalBookCount(){
		return sqlSession.selectOne(NS+"selectTotalBookCount");
	}
	
	public List<BRent> selectRent(Map<String, Integer>map){
		
		return sqlSession.selectList(NS+"selectRent",map);
	}
	
	public int selectTotalRentCount(){
		return sqlSession.selectOne(NS+"selectTotalRentCount");
	}
}
