package com.glsx.hbase.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HBaseToHBase extends Configured implements Tool {

	private static final Logger logger = LoggerFactory.getLogger(HBaseToHBase.class);
	
	public static class ReadHBaseMapper extends TableMapper<Text, Put> {

		@Override
		protected void map(ImmutableBytesWritable key, Result value,
				Context context) throws IOException, InterruptedException {

		}
	}

	public static class WriteHBaseReducer extends
			TableReducer<Text, Put, ImmutableBytesWritable> {

		@Override
		protected void reduce(Text key, Iterable<Put> values, Context context)
				throws IOException, InterruptedException {
			
		}

	}

	public static void main(String[] args) {
		logger.info("the application is running...");
		System.setProperty("hadoop.home.dir", "hadoop");
		Configuration conf = HBaseConfiguration.create();
		conf.dumpDeprecatedKeys();
		logger.info(conf.get("fs.defaultFS"));
		int status = 0;
		try {
			status = ToolRunner.run(conf, new HBaseToHBase(), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(status);
	}

	public int run(String[] arg0) throws Exception {
		logger.info("conf={},className=", this.getConf(), this.getClass().getSimpleName());
		Job job = Job.getInstance(this.getConf(), this.getClass().getSimpleName());
		
		return 0;
	}

}
