package com.yang.empl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yang.empl.dao.EmpDao;
import com.yang.empl.vo.DepartmentVo;
import com.yang.empl.vo.EmpListVo;
import com.yang.empl.vo.ImageVo;
import com.yang.empl.vo.PayforVo;
import com.yang.empl.vo.PositionVo;
import com.yang.empl.vo.RegionVo;

@Service
public class EmpService {
	
	@Autowired
	private EmpDao edao;
	
	public int getIdSequence() {
		return edao.getIdSequence();
	}
	@Transactional(rollbackFor = {Exception.class})
	public int insertTransaction(HashMap<String, Object> empMap,
			String department,String position) throws Exception {
		
		//아이디 만들어내기 (부서번호+직위번호+0+순차적인 시퀀스)
		
		//시퀀스 뽑기
		int seq=edao.getIdSequence();
		
		String id=department+""+position+"0"+seq;
		
		//비밀번호 난수 만들기(6자리)
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		for(int i = 0; i < 6; i++){ 
			int index = rnd.nextInt(3);
	    	switch (index) {
	    		case 0:
	    			key.append((char)((int) (rnd.nextInt(26)) + 97));
	    			break;
	    		case 1:
	    			key.append((char)((int) (rnd.nextInt(26)) + 65));
	    			break;
	    		case 2:
	    			key.append((rnd.nextInt(10)));
	    			break;
	    	}
		}
		
		String password=key.toString();
		
		System.out.println("id:"+id);
		System.out.println("password:"+password);
		
		//아이디 패스워드 등록 + 리스트 저장
		HashMap<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("userid", id);
		userMap.put("userpassword", password);
		
		//emplist에도 추가로 아이디 저장
		empMap.put("userid", id);
		
		edao.userInsert(userMap);
		edao.empInsert(empMap);
		
		return 1;
	}
	public List<EmpListVo> getEmployee(HashMap<String, Object> map){
		return edao.getEmployee(map);
	}
	public EmpListVo getEmpOne(int empnum) {
		return edao.getEmpOne(empnum);
	}
	public int updateEmp(HashMap<String, Object> map) {
		return edao.updateEmp(map);
	}
	public int countEmp(HashMap<String, Object> map) {
		return edao.countEmp(map);
	}
	//직원 삭제
	@Transactional(rollbackFor = {Exception.class})
	public int deleteEmp(String userid,int empNum) {
		edao.deleteAuth(userid);
		edao.deletePhoto(empNum);
		edao.deleteEmp(userid);
		edao.deleteUser(userid);
		return 1;
	}
	//사진 추가
	public int insertPhoto(HashMap<String, Object> map) {
		return edao.insertPhoto(map);
	}
	//사진조회
	public ImageVo getPhoto(int empnum) {
		return edao.getPhoto(empnum);
	}
}
