package com;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //1. 获取一个Job实例
        Job job = Job.getInstance(new Configuration());

        //2. 设置我们的类路径（Classpath）
        job.setJarByClass(WordCountDriver.class);

        //3. 设置Mapper和Reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        //4. 设置Mapper和Reducer 输出的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //5. 设置输入输出数据
//        FileInputFormat.setInputPaths(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        FileInputFormat.setInputPaths(job, new Path("/Users/wangyuhang/Desktop/temp"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/wangyuhang/Desktop/output"));

        //6. 提交我们的Job
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}
