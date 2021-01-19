import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.apache.parquet.schema.MessageType;

import java.io.IOException;

public class Program {
    /*
    * in hdp cmd
    *
    * hadoop jar untitled1.jar /weather/year=2016/month=10/day=1/part-00140-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
    *
    *
    *
    * results
    *
    * message spark_schema {
          optional double lng;
          optional double lat;
          optional double avg_tmpr_f;
          optional double avg_tmpr_c;
          optional binary wthr_date (STRING);
      }
    * */

    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            throw new IOException("Path to file is required. Add as cmd argument");
        }

        Configuration conf = new Configuration();
        Path path = new Path("hdfs://" + args[0]);

        try {
            ParquetMetadata readFooter = ParquetFileReader.readFooter(conf, path, ParquetMetadataConverter.NO_FILTER);
            MessageType schema = readFooter.getFileMetaData().getSchema();
            System.out.println(schema);
        } catch (IOException e) {
            System.out.println("Error reading parquet file.");
            e.printStackTrace();
        }

    }
}
