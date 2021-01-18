import org.apache.avro.Schema;
import org.apache.avro.file.DataFileStream;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class Program {
    /*
     *
     * in hdp
     * hadoop jar untitled1.jar /expedia/part-00022-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
     *
     *
     * and result
     *
     * {"type":"record","name":"topLevelRecord","fields":[{"name":"id","type":["long","null"]},
     * {"name":"date_time","type":["string","null"]},{"name":"site_name","type":["int","null"]},
     * {"name":"posa_continent","type":["int","null"]},{"name":"user_location_country","type":["int","null"]},
     * {"name":"user_location_region","type":["int","null"]},{"name":"user_location_city","type":["int","null"]},
     * {"name":"orig_destination_distance","type":["double","null"]},{"name":"user_id","type":["int","null"]},
     * {"name":"is_mobile","type":["int","null"]},{"name":"is_package","type":["int","null"]},
     * {"name":"channel","type":["int","null"]},{"name":"srch_ci","type":["string","null"]},
     * {"name":"srch_co","type":["string","null"]},{"name":"srch_adults_cnt","type":["int","null"]},
     * {"name":"srch_children_cnt","type":["int","null"]},{"name":"srch_rm_cnt","type":["int","null"]},
     * {"name":"srch_destination_id","type":["int","null"]},{"name":"srch_destination_type_id","type":["int","null"]},
     * {"name":"hotel_id","type":["long","null"]}]}
     *
     * */

    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            throw new IOException("Path to file is required. Add as cmd argument");
        }

        String path = "hdfs://" + args[0];

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path file = new Path(path);

        if(!fs.exists(file)){
            System.out.println("Input file not found!");
            throw new IOException("No file");
        }

        try(FSDataInputStream in = fs.open(file)) {
            GenericDatumReader<GenericRecord> datum = new GenericDatumReader<>();

            try(DataFileStream<GenericRecord> data = new DataFileStream<>(in, datum)) {
                Schema ret = data.getSchema();

                System.out.println(ret);
            }
        }
    }
}
