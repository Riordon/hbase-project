package com.glsx.hbase.operator;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glsx.hbase.mapreduce.HBaseToHBase;

public class HBaseOperator {
	private static final Logger logger = LoggerFactory.getLogger(HBaseToHBase.class);
	
	public static HTable getHTableByTableName(String tableName) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		logger.info(conf.get("fs.defaultFS"));
		
		HTable table = new HTable(conf,tableName);
		return table;
	}
	
	public static void putData() throws IOException {
		HTable table = getHTableByTableName("fromTable");
		
		Put put = new Put(Bytes.toBytes("row1"));
		put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("xiaolong"));
		
		table.put(put);
		
		table.close();
	}
	
	public static void main(String[] args) throws IOException {
		logger.info("Hbase start...");
		System.setProperty("hadoop.home.dir", "E:\\工作软件\\hadoop-2.3.0-cdh5.0.2\\hadoop-2.3.0-cdh5.0.2");
		
		putData();
	}

}
