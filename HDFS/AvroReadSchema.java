import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {


        String path = "/Users/Andrei_Pak/Work/hadoop/expedia/part-00022-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro";

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(new File(path), datumReader);
        Schema schema = dataFileReader.getSchema();
        System.out.println(schema);


    }
}

