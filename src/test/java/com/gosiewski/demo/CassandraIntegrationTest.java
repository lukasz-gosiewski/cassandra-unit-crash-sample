package com.gosiewski.demo;

import com.datastax.driver.core.Cluster;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class CassandraIntegrationTest {

    @BeforeClass
    public static void init() throws IOException, TTransportException, InterruptedException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
    }

    @After
    public void cleanUp() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }

    @Test
    public void shouldStartEmbeddedCassandraTest() {
        Cluster cluster = new Cluster.Builder().addContactPoints("127.0.0.1").withPort(9142).build();
        cluster.connect();
    }
}
