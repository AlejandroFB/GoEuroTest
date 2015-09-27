package com.goeuro.services;

import java.io.IOException;
import java.util.List;

import com.goeuro.domain.Position;

/**
 * This interface defines the functionality we want the CSVParser to offer.
 * 
 */
public interface GenericCSVParser {
	
	/**
	 * Takes a list of positions objects to parse them to a CSV file.
	 * 
	 * @param positions
	 *            The list of position objects
	 * @throws IOException
	 * 
	 */
	public void writeCSVData(List<Position> positions) throws IOException;
}
