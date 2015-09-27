package com.goeuro.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.goeuro.domain.Position;
import com.goeuro.services.GenericCSVParser;
import com.goeuro.services.GenericCSVParserApacheImpl;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final static Logger log = LoggerFactory.getLogger(Application.class);
	private final static String FILE_PATH = "positions.csv";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String url = "";
		
		try {
			url = String.format("http://api.goeuro.com/api/v2/position/suggest/en/%s", args[0]);
			
			RestTemplate restTemplate = new RestTemplate();
			
			log.info("Performing REST call to GoEuro API endpoint");
			List<Position> positions = Arrays.asList(restTemplate.getForObject(url, Position[].class));
			log.info("Position Object: {}", positions.toString());			
			
			GenericCSVParser csvParser = new GenericCSVParserApacheImpl(FILE_PATH);
			log.info("Writing data to CSV file");
			csvParser.writeCSVData(positions);	
			
			System.out.println("CSV file has been created.");
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("The CITY input parameter was not introduced properly");
		}	
		catch (IOException ioex) {
			System.out.println(String.format("Something went wrong writing to the CSV file: %s", ioex.getMessage()));
		}		
	}
}
