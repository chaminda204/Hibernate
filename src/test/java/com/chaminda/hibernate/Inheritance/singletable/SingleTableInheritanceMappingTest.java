package com.chaminda.hibernate.Inheritance.singletable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaminda.hibernate.common.AbstractTest;
import com.chaminda.hibernate.dao.PersonDao;
import com.chaminda.hibernate.inheritance.singletable.Member;
import com.chaminda.hibernate.inheritance.singletable.Visitor;

public class SingleTableInheritanceMappingTest extends AbstractTest{

	@Autowired
	PersonDao personDao ;

	@Test
	public void shouldInitialiseMemberDao() {
		Assert.assertNotNull(personDao);
	}
	
	@Test
	public void shouldSucessfullySaveMemberWithSingleTableMapping(){
		//Given
		Member member = getMemberForTesting();

		//When
		Member savedMember =personDao.save(member);
		
		//Then - Please check the database table to verify this
		assertNotNull(savedMember);
		assertNotNull(savedMember.getPersonId());
		assertEquals(member.getMembershipNo(), savedMember.getMembershipNo());
	}
	
	private Member getMemberForTesting(){
		Member member = new Member();
		member.setPersonName("Member Cham");
		member.setMembershipNo("M-1501500");
		return member;
	}
	
	@Test
	public void shouldSucessfullySaveVisitorWithSingleTableMapping(){
		//Given
		Visitor visitor = getVisitorForTesting();

		//When
		Visitor savedVisitor =personDao.save(visitor);
		
		//Then - Please check the database table to verify this
		assertNotNull(savedVisitor);
		assertNotNull(savedVisitor.getPersonId());
		assertEquals(visitor.getPurposeOfVisit(), savedVisitor.getPurposeOfVisit());
	}
	private Visitor getVisitorForTesting(){
		Visitor visitor = new Visitor();
		visitor.setPersonName("Visitor Cham");
		visitor.setPurposeOfVisit("Meeting");
		return visitor;
	}


}
