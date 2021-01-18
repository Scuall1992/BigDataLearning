import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.file.SeekableInput;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(conf);

        String path = "hdfs:///expedia/part-00022-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro";

        Path file = new Path(path);

        if(!fs.exists(file)){
            System.out.println("Input file not found!");
            throw new IOException("No file");
        }

        FSDataInputStream in = fs.open(file);

        DataFileStream<GenericRecord> data = new DataFileStream<>(in, new GenericDatumReader<GenericRecord>());

        Schema ret = data.getSchema();

        System.out.println(ret);

        data.close();



    }
}
