package com.everis.batch;

import com.everis.report.batch.job.ReportBatchWriter;

import junit.framework.TestCase;

public class ExampleItemWriterTests extends TestCase {

	private ReportBatchWriter writer = new ReportBatchWriter();
	
	public void testWrite() throws Exception {
		writer.write(null); // nothing bad happens
	}

}
