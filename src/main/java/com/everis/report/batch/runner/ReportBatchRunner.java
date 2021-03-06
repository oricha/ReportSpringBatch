package com.everis.report.batch.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
/**
 * 
 * @author kmunizpe
 *
 */
public class ReportBatchRunner {

	
	private static final Logger LOG = LoggerFactory.getLogger(ReportBatchRunner.class);

	private static final String FILE = "classpath:/resources/fichero.log";

	private JobLauncher jobLauncher;
	
	private Job job;
	
	public void launch(String file) throws Exception {
		LOG.info("starting import for file {}",file);
		JobExecution exec = jobLauncher.run(
			job, 
			new JobParametersBuilder()
				.addString("input.file", "file:"+file)
				.addLong("time",System.currentTimeMillis())
				.toJobParameters()
		);
		LOG.info("job ended with status {}",exec);
	}
	
	public void setJob(Job job) {
		this.job = job;
	}
	
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}
	
	public static void main(String[] args) {
        ReportBatchRunner runner = new ReportBatchRunner();
        try {
			runner.launch(FILE);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
    }
	
}
