# Description
## Task 1 (Need to be done on HDFS inside WSL2)

 - Download the data set here.
 - Install and start HDFS in WSL2. Use "Hadoop WSL2 Setup" guide for this.
 - Unzip these files and put them in HDFS system with the same hierarchy as they are in archive.
 - Make screenshots of data in HDFS from console.
 - Though Hadoop API, Parquet and Avro Tools (1.7.x version of avro tools is compatible with 3.x Hadoop) receive schema from Avro (Expedia) & Parquet (Weather) files.
 - Make screenshots of schema in console.
 - Collect rows count in Avro (Expedia) dataset using shell scripting and Avro Tools.
 - Make screenshots of output.

---

# Что было сделано

### 1. Установил HDP Cloudera. 

### 2. Скопировал папки в контейнер

`docker container cp weather <container ID>:/root/` \
`docker container cp expedia <container ID>:/root/`

### 3. Скопировал jar файлы avro parquet tools

`docker container cp ~/Downloads/jar_files/avro-tools-1.7.4.jar <container ID>:/root/`
`docker container cp parquet-tools-1.8.0.jar <container ID>:/root`

### 4. Подключился к контейнеру

`docker exec -it <container ID> /bin/bash`


### 5. Скопировал папки в hdfs

`hadoop fs -put expedia .`
`hadoop fs -put weather .`

### 6. Сделал рекурсивный вывод содержимого

`hdfs dfs -ls -R`

>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:12 expedia
>        -rw-r--r--   1 root hdfs          0 2021-01-12 13:12 expedia/_SUCCESS
>        -rw-r--r--   1 root hdfs    5517132 2021-01-12 13:12 expedia/part-00000-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5540585 2021-01-12 13:12 expedia/part-00001-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5542617 2021-01-12 13:12 expedia/part-00002-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5522153 2021-01-12 13:12 expedia/part-00003-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5536878 2021-01-12 13:12 expedia/part-00004-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5501960 2021-01-12 13:12 expedia/part-00005-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5510606 2021-01-12 13:12 expedia/part-00006-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5494875 2021-01-12 13:12 expedia/part-00007-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5514343 2021-01-12 13:12 expedia/part-00008-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5518922 2021-01-12 13:12 expedia/part-00009-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5516854 2021-01-12 13:12 expedia/part-00010-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5518093 2021-01-12 13:12 expedia/part-00011-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5518985 2021-01-12 13:12 expedia/part-00012-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5499998 2021-01-12 13:12 expedia/part-00013-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5526399 2021-01-12 13:12 expedia/part-00014-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5549270 2021-01-12 13:12 expedia/part-00015-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5518698 2021-01-12 13:12 expedia/part-00016-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5493230 2021-01-12 13:12 expedia/part-00017-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5516936 2021-01-12 13:12 expedia/part-00018-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5510365 2021-01-12 13:12 expedia/part-00019-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5500211 2021-01-12 13:12 expedia/part-00020-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5518510 2021-01-12 13:12 expedia/part-00021-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5523346 2021-01-12 13:12 expedia/part-00022-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5529502 2021-01-12 13:12 expedia/part-00023-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        -rw-r--r--   1 root hdfs    5545703 2021-01-12 13:12 expedia/part-00024-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather
>        -rw-r--r--   1 root hdfs       6148 2021-01-12 13:13 weather/.DS_Store
>        -rw-r--r--   1 root hdfs          0 2021-01-12 13:13 weather/_SUCCESS
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016
>        -rw-r--r--   1 root hdfs       6148 2021-01-12 13:13 weather/year=2016/.DS_Store
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016/month=10
>        -rw-r--r--   1 root hdfs       8196 2021-01-12 13:13 weather/year=2016/month=10/.DS_Store
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016/month=10/day=1
>        -rw-r--r--   1 root hdfs    5951226 2021-01-12 13:13 weather/year=2016/month=10/day=1/part-00140-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    1795221 2021-01-12 13:13 weather/year=2016/month=10/day=1/part-00141-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    2413072 2021-01-12 13:13 weather/year=2016/month=10/day=1/part-00229-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016/month=10/day=10
>        -rw-r--r--   1 root hdfs    5956203 2021-01-12 13:13 weather/year=2016/month=10/day=10/part-00169-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    1785007 2021-01-12 13:13 weather/year=2016/month=10/day=10/part-00170-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    2428432 2021-01-12 13:13 weather/year=2016/month=10/day=10/part-00224-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016/month=10/day=11
>        -rw-r--r--   1 root hdfs    5955950 2021-01-12 13:13 weather/year=2016/month=10/day=11/part-00035-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    1784405 2021-01-12 13:13 weather/year=2016/month=10/day=11/part-00036-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        -rw-r--r--   1 root hdfs    2435707 2021-01-12 13:13 weather/year=2016/month=10/day=11/part-00228-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet
>        drwxr-xr-x   - root hdfs          0 2021-01-12 13:13 weather/year=2016/month=10/day=12
>        ......


### 7. Запросил схемы файлов

`hadoop jar avro-tools-1.7.4.jar tojson --pretty expedia/part-00024-ef2b800c-0702-462d-b37f-5f2fb3a093d0-c000.avro `


> {"id":{"long":9},"date_time":{"string":"2015-11-08 16:21:37"},"site_name":{"int":2},"posa_continent":{"int":3},"user_location_country":{"int":66},"user_location_region":{"int":311},"user_location_city":{"int":48189},"orig_destination_distance":{"double":2539.7995},"user_id":{"int":51},"is_mobile":{"int":0},"is_package":{"int":0},"channel":{"int":10},"srch_ci":{"string":"2017-08-02"},"srch_co":{"string":"2017-08-03"},"srch_adults_cnt":{"int":2},"srch_children_cnt":{"int":0},"srch_rm_cnt":{"int":1},"srch_destination_id":{"int":9145},"srch_destination_type_id":{"int":1},"hotel_id":{"long":1202590842886}}
> {"id":{"long":46},"date_time":{"string":"2015-08-14 19:52:56"},"site_name":{"int":2},"posa_continent":{"int":3},"user_location_country":{"int":66},"user_location_region":{"int":348},"user_location_city":{"int":24562},"orig_destination_distance":{"double":144.2556},"user_id":{"int":259},"is_mobile":{"int":0},"is_package":{"int":0},"channel":{"int":10},"srch_ci":{"string":"2017-09-18"},"srch_co":{"string":"2017-09-19"},"srch_adults_cnt":{"int":1},"srch_children_cnt":{"int":0},"srch_rm_cnt":{"int":1},"srch_destination_id":{"int":11975},"srch_destination_type_id":{"int":1},"hotel_id":{"long":2602750181387}}
> {"id":{"long":104},"date_time":{"string":"2015-07-07 17:05:10"},"site_name":{"int":11},"posa_continent":{"int":3},"user_location_country":{"int":205},"user_location_region":{"int":312},"user_location_city":{"int":22859},"orig_destination_distance":{"double":60.3816},"user_id":{"int":414},"is_mobile":{"int":0},"is_package":{"int":0},"channel":{"int":10},"srch_ci":{"string":"2017-08-03"},"srch_co":{"string":"2017-08-04"},"srch_adults_cnt":{"int":2},"srch_children_cnt":{"int":2},"srch_rm_cnt":{"int":1},"srch_destination_id":{"int":53976},"srch_destination_type_id":{"int":4},"hotel_id":{"long":2310692405248}}
> {"id":{"long":166},"date_time":{"string":"2015-11-28 09:23:37"},"site_name":{"int":2},"posa_continent":{"int":3},"user_location_country":{"int":129},"user_location_region":{"int":311},"user_location_city":{"int":47779},"orig_destination_distance":null,"user_id":{"int":702},"is_mobile":{"int":0},"is_package":{"int":0},"channel":{"int":10},"srch_ci":{"string":"2017-09-30"},"srch_co":{"string":"2017-10-06"},"srch_adults_cnt":{"int":2},"srch_children_cnt":{"int":0},"srch_rm_cnt":{"int":1},"srch_destination_id":{"int":1014},"srch_destination_type_id":{"int":1},"hotel_id":{"long":2826088480770}}

`hadoop jar parquet-tools-1.8.0.jar meta --debug weather/year\=2016/month\=10/day\=1/part-00140-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet`

> file:        hdfs://sandbox-hdp.hortonworks.com:8020/user/root/weather/year=2016/month=10/day=1/part-00140-44bd3411-fbe4-4e16-b667-7ec0fc3ad489.c000.snappy.parquet 
> creator:     parquet-mr version 1.8.2 (build c6522788629e590a53eb79874b95f6c3ff11f16c) \
> `extra:       org.apache.spark.sql.parquet.row.metadata = {"type":"struct","fields":[{"name":"lng","type":"double","nullable":true,"metadata":{}},{"name":"lat","type":"double","nullable":true,"metadata":{}},{"name":"avg_tmpr_f","type":"double","nullable":true,"metadata":{}},{"name":"avg_tmpr_c","type":"double","nullable":true,"metadata":{}},{"name":"wthr_date","type":"string","nullable":true,"metadata":{}}]} `\
> file schema: spark_schema 
> lng:         OPTIONAL DOUBLE R:0 D:1
> lat:         OPTIONAL DOUBLE R:0 D:1
> avg_tmpr_f:  OPTIONAL DOUBLE R:0 D:1
> avg_tmpr_c:  OPTIONAL DOUBLE R:0 D:1
> wthr_date:   OPTIONAL BINARY O:UTF8 R:0 D:1
> 
> row group 1: RC:465299 TS:7985543 OFFSET:4 
> lng:          DOUBLE SNAPPY DO:0 FPO:4 SZ:2619170/3654016/1.40 VC:465299 ENC:PLAIN,PLAIN_DICTIONARY,BIT_PACKED,RLE
> lat:          DOUBLE SNAPPY DO:0 FPO:2619174 SZ:2234047/3215998/1.44 VC:465299 ENC:PLAIN,PLAIN_DICTIONARY,BIT_PACKED,RLE
> avg_tmpr_f:   DOUBLE SNAPPY DO:0 FPO:4853221 SZ:581165/588075/1.01 VC:465299 ENC:PLAIN_DICTIONARY,BIT_PACKED,RLE
> avg_tmpr_c:   DOUBLE SNAPPY DO:0 FPO:5434386 SZ:515351/527014/1.02 VC:465299 ENC:PLAIN_DICTIONARY,BIT_PACKED,RLE
> wthr_date:    BINARY SNAPPY DO:0 FPO:5949737 SZ:456/440/0.96 VC:465299 ENC:PLAIN_DICTIONARY,BIT_PACKED,RLE


