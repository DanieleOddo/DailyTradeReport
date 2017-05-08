/**
 * 
 */
package com.jpmorgan.InstructionTradeReport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.InstructionEntity;

/**
 * @author Daniele Oddo
 *
 */
public class ReadFileInstruction {
	
	private static final String sourceClass = ReadFileInstruction.class.getSimpleName();
	private Logger logger = Logger.getLogger(sourceClass);
	
	public List<InstructionEntity> readFileInput(String nomeFile) throws MyOwnException {
		final String sourceMethod = "readFileInput";
		BufferedReader br = null;
		List<InstructionEntity> lista = new ArrayList<InstructionEntity>();
		try {			
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nomeFile);
			
			String line = "";
			String cvsSplitBy = ";";

			br = new BufferedReader(new InputStreamReader(inputStream ));
			
			while ((line = br.readLine()) != null) {
				InstructionEntity elem = new InstructionEntity();
	            // use comma as separator
	            String[] instruction = line.split(cvsSplitBy);
	            String entity = instruction[0];
	            elem.setEntity(entity);
	            String action = instruction[1];
	            elem.setFlgAction(action);
	            String agreedFx = instruction[2];
	            elem.setAgreedFx(agreedFx);
	            String currency = instruction[3];
	            elem.setCurrency(currency);
	            String instructionDate = instruction[4];
	            elem.setInstructionDate(instructionDate);
	            String settlementDate = instruction[5];
	            elem.setSettlementDate(settlementDate);
	            String units = instruction[6];
	            elem.setUnits(units);
	            String pricePerUnit = instruction[6];
	            elem.setPricePerUnit(pricePerUnit);
	            lista.add(elem);
	        }
			System.out.println("");
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Exception During ReadFile Input: ", e.getClass().getSimpleName());
			throw new MyOwnException("Exception During ReadFile Input :" +e.getClass().getSimpleName());
		}  finally {
	        if (br != null) {
	            try {
	                br.close();
	                return lista;
	            } catch (IOException e) {
	            	logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Exception During ReadFile Input : ", e.getClass().getSimpleName());
	    			throw new MyOwnException("Exception During ReadFile Input :" +e.getClass().getSimpleName());
	            }
	        }
	    }
		return null;
	}
}
