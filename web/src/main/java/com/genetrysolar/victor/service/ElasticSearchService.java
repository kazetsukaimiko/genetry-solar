package com.genetrysolar.victor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ElasticSearchService {
    private static final Logger LOGGER = Logger.getLogger(ElasticSearchService.class.getName());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Inject
    private RestHighLevelClient client;

    public boolean isIndexRegistered(String indexName) throws IOException {
        return client
                .indices()
                .exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
    }

    public boolean createIndex(String indexName) throws IOException {
        return isIndexRegistered(indexName) || client
                .indices()
                .create(new CreateIndexRequest(indexName), RequestOptions.DEFAULT)
                .isAcknowledged();
    }

    public <T> boolean bulkInsert(String indexName, List<T> allT) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();

        allT
                .forEach(t -> {
                    bulkRequest.setRefreshPolicy(RefreshPolicy.IMMEDIATE).add(
                            new IndexRequest(indexName)
                                    .source(json(t), XContentType.JSON));
                });

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        if (bulkResponse.hasFailures()) {
            // process failures by iterating through each bulk response item
            LOGGER.info("Bulk insert failed!");
            return false;
        }

        return true;
    }

    private <T> String json(T t) {
        try {
            return OBJECT_MAPPER.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to jsonify", e);
        }
    }
}
