package com.madshines.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class Test {
	public static void main(String[] args) throws SolrServerException, IOException {
		System.out.println("test");
		SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr/collection1");
		SolrInputDocument solrInputDocument=new SolrInputDocument();
		solrInputDocument.setField("id", 1111);
		solrInputDocument.setField("name", "tom");
		solrServer.add(solrInputDocument);
		solrServer.commit();
	}
}
