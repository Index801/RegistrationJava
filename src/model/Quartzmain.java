package model;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class Quartzmain {

	public void remove(String remove) {

		JobDetail job = JobBuilder.newJob(QuartzJobRemove.class).build();

		Trigger t1 = (Trigger) TriggerBuilder.newTrigger().withIdentity("simpletrigger")
				.withSchedule(CronScheduleBuilder.cronSchedule(remove)).build();

		Scheduler sc;
		try {
			sc = StdSchedulerFactory.getDefaultScheduler();
			sc.start();
			sc.scheduleJob(job, t1);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

	public void disale(String disable) {

		JobDetail job = JobBuilder.newJob(QuartzDisableJob.class).build();

		Trigger t1 = (Trigger) TriggerBuilder.newTrigger().withIdentity("simpletrigger1")
				.withSchedule(CronScheduleBuilder.cronSchedule(disable)).build();

		Scheduler sc;
		try {
			sc = StdSchedulerFactory.getDefaultScheduler();
			sc.start();
			sc.scheduleJob(job, t1);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
