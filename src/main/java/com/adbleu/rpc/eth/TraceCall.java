package com.tlchain.rpc.eth;

import org.apache.log4j.Logger;

import com.tlchain.jsonrpc.JsonCall;
import com.tlchain.util.HttpClient;

public class TraceCall {

	private static final Logger LOG = Logger.getLogger(TraceCall.class);

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
					.setMethod("trace_call").addObjectParam("from", fromAddress).addObjectParam("to", toAddress)
					.addObjectParam("data", encodedData).addArrayParam("vmTrace").addArrayParam("trace")
					.addArrayParam("stateDiff"));

			return response;

		} catch (Exception e) {
			LOG.error("", e);
			return e.getMessage();
		}

	}

}
