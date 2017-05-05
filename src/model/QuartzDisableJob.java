package model;

import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzDisableJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		DbUser db = new DbUser();
		
		try {
			db.DisableUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
