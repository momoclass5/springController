package com.momo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.momo.mapper.MemberMapper;
import com.momo.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public Member login(Member member) {
		return memberMapper.login(member);
	}

	@Override
	public int insert(Member member) {
		
		// 비밀번호 암호화
		BCryptPasswordEncoder encoder 
						= new BCryptPasswordEncoder();
		member.setPw(encoder.encode(member.getPw()));
		System.out.println("pw : " + member.getPw());
		return memberMapper.insert(member);
	}

	@Override
	public int idCheck(Member member) {
		return memberMapper.idCheck(member);
	}
	
}
