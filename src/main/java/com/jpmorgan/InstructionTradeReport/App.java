package com.jpmorgan.InstructionTradeReport;

import java.util.List;

import com.jpmorgan.InstructionTradeReport.exception.MyOwnException;
import com.jpmorgan.InstructionTradeReport.model.InstructionEntity;
import com.jpmorgan.InstructionTradeReport.model.OutgoingDetailEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MyOwnException
    {
    	
    	ReadFileInstruction read = new ReadFileInstruction();
    	List<InstructionEntity> listIns = read.readFileInput("instruction.csv");
    	CreateListOutgoingDetails creaOut = new CreateListOutgoingDetails();
    	List<OutgoingDetailEntity> listOut = creaOut.listOutDetail(listIns);
    	DailyTradeReportGenerator tradeReport = new DailyTradeReportGenerator();
    	tradeReport.inConsoleReport(listOut);
    	System.out.println("-------------------------------------------");
        System.out.println( "Hello Work Completed!" );
    }
}
