package com.goeuro.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.goeuro.domain.Position;

public class GenericCSVParserApacheImpl implements GenericCSVParser {

	private final static char STRING_DELIMITER = ',';
	
	private String file_path;

	public GenericCSVParserApacheImpl(String file_path) {
		this.file_path = file_path;
	}
	
	@Override
	public void writeCSVData(List<Position> positions) throws IOException {	
		
		FileWriter fileWriter = new FileWriter(file_path);
		String[] header = {"_id", "name", "type", "latitude", "longitude"};
		
		// Create the CSVFormat object
        CSVFormat format = CSVFormat.RFC4180.withHeader(header).withDelimiter(STRING_DELIMITER);
        
		// CSV Write Example using CSVPrinter
        CSVPrinter printer = new CSVPrinter(fileWriter, format);

        for (Position next : positions) {
            List<String> positionData = new ArrayList<String>();
            positionData.add(String.valueOf(next.getId()));
            positionData.add(next.getName());
            positionData.add(next.getType());
            positionData.add(String.valueOf(next.getGeoPosition().getLatitude()));
            positionData.add(String.valueOf(next.getGeoPosition().getLongitude()));
            printer.printRecord(positionData);
        }    
        // Close the printer
        printer.close();		
	}
}
