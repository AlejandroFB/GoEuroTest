package com.goeuro.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.goeuro.domain.Position;

/**
 * Tests for the implementation of the CSV Parser using Apache Commons CSV.
 */
public class GenericCSVParserApacheImplTest {

	@Test(expected = IOException.class)  
	public void testThrowIOException() throws IOException {
		
		List<Position> positions = new ArrayList<Position>();
		
		GenericCSVParser parser = new GenericCSVParserApacheImpl("*thisIsNotAValidPath*");
		parser.writeCSVData(positions);
	}
}
