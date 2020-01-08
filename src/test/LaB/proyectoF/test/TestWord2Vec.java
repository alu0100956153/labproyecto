
 
 package LaB.proyectoF.test;


import java.io.ByteArrayInputStream;

import java.io.InputStream;

import static org.junit.Assert.*;


import org.junit.Test;

import LaB.proyectoF.main.*;

/**
 * Unit test for simple App.
 */
public class TestWord2Vec {
	

	@Test
	public void testNormalInput() {
		String input = "word";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		String result= Word2VecModelExample.getInputFile();
		assertEquals(result.equals("word.txt"),true);
		
		
		
	}
	
	@Test
	public void testEmptylInput() {
		String input = "";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		String result = Word2VecModelExample.getInputFile();
		assertNull(result);
	
		
		
	}
	
	@Test
	public void testLargeInput() {
		String input = "wordislargeandverylargeandverymuchlargerhtanyouthinkitis";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		String result= Word2VecModelExample.getInputFile();
		assertEquals(result.equals("wordi.txt"),true);
		
		
		
	}
	
	
}