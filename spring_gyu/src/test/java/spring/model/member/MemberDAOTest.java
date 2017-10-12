package spring.model.member;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MemberDAOTest {
	
	private static BeanFactory beans;
	private static MemberDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("META-INF/gyu.xml");
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = (MemberDAO)beans.getBean("memberdao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setId("user2");
		dto.setPasswd("1234");
		dto.setName("JUNITTEST");
		dto.setZipcode("55522");
		dto.setAddress1("제이동");
		dto.setAddress2("유닛리");
		assertTrue(dao.create(dto));
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testDuplicateId() {
		fail("Not yet implemented");
	}

}
