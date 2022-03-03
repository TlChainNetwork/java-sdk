package com.tlchain.rpc.eth;

import org.apache.log4j.Logger;

import com.tlchain.jsonrpc.JsonCall;
import com.tlchain.util.HttpClient;
import com.jayway.jsonpath.JsonPath;

public class InvokeCall {

	private static final Logger LOG = Logger.getLogger(InvokeCall.class);

	/**
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param file
	 * @param gas
	 * @param gasValue
	 * @return
	 */
	public String execute(final String fromAddress, final String toAddress, final String encodedData) {

		try {

			String response = HttpClient.execute(new JsonCall().setId(String.valueOf(System.nanoTime()))
					.setMethod("eth_call").addObjectParam("from", fromAddress).addObjectParam("to", toAddress)
					.addObjectParam("data", encodedData));

			LOG.info(response);

			String result = JsonPath.read(response, "$.result");

			return result;

		} catch (Exception e) {
			LOG.error("", e);
			return e.getMessage();
		}

	}

}
