package dml;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-28 10:49
 **/
public class ShowInfo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.2.129:9091,192.168.2.129:9092,192.168.2.129:9093");
        AdminClient client = KafkaAdminClient.create(config);

       /* DeleteTopicsResult topic1 = client.deleteTopics(Arrays.asList("topic1"));
        topic1.all().get();*/
        /*CreateTopicsResult topics = client.createTopics(Arrays.asList(new NewTopic("topic03", 3, (short) 3)));
        topics.all().get();*/

       /* DeleteConsumerGroupsResult group01 = client.deleteConsumerGroups(Arrays.asList("group01"));
        group01.all().get();*/

        KafkaFuture<Set<String>> names = client.listTopics().names();
        names.get().stream().forEach(System.out::println);


        KafkaFuture<Collection<ConsumerGroupListing>> groups = client.listConsumerGroups().all();
        Collection<ConsumerGroupListing> lists = groups.get();
        lists.forEach(System.out::println);

        client.close();
    }
}
