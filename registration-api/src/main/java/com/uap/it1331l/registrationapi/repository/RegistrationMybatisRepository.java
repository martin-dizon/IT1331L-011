package com.uap.it1331l.registrationapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.uap.it1331l.registrationapi.model.Attendee;

@Mapper
public interface RegistrationMybatisRepository {
	@Insert("INSERT INTO attendees(firstName, middleName, lastName, course, age) VALUES (#{firstName}, #{middleName}, #{lastName}, #{course}, #{age})")
	public int insert(Attendee attendee);
	@Select("SELECT * FROM attendees")
	public List<Attendee> findAll();
	@Update("UPDATE attendees SET surveyEligibilityTag = true WHERE course = 'BSIT'")
	public int updateEligibility();
	@Select("SELECT * FROM attendees WHERE surveyEligibilityTag = true")
	public List<Attendee> getAllEligible();
	@Delete("DELETE FROM attendees WHERE attendeeId = #{attendeeId}")
	public int deleteId(int attendeeId);
}
