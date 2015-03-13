package com.aerospike.examples;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.policy.ClientPolicy;

public class Client {

	public static void main(String[] args) {

		
		ClientPolicy cPolicy = new ClientPolicy();
		cPolicy.timeout=500;
		
		
	   AerospikeClient aerospikeClient = new AerospikeClient(cPolicy,"localhost",3000);

	   Key key = new Key("test","demo","putgetkey");
	   Bin  bin1 = new Bin("bin1","value1");
	   Bin  bin2 = new Bin("bin2","value2");
	   
	//   aerospikeClient.put(null, key, bin1,bin2);
	   
	   Record record = aerospikeClient.get(null, key);
	   
	   System.out.println("Record"+record);
	   
	   aerospikeClient.close();
	}

	
}
