package com.tlchain.rpc.eth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.tlchain.jsonrpc.JsonCall;
import com.tlchain.rpc.personal.ListAccounts;
import com.tlchain.util.HexUtil;
import com.tlchain.util.HttpClient;
import com.tlchain.util.JsonUtil;

/**
 * 
 * Returns the balance of the account of given address.
 * 
 */
public class GetBalance {

	/**
	 * 
	 * @param address
	 * @return
	 */
	public String execute(final String address) {
		try {
			return HttpClient.execute(new JsonCall().setId(String.valueOf(System.nanoTime()))
					.setMethod("eth_getBalance").addStringParam(address));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String execute() {
		try {
			String result = new ListAccounts().execute();
			List<String> accounts = JsonUtil.parseArray(new ByteArrayInputStream(result.getBytes()), "$.result");
			StringBuilder sb = new StringBuilder();
			accounts.forEach(acc -> {
				String response = execute(acc);
				try {
					String balance = JsonUtil.parse(new ByteArrayInputStream(response.getBytes()), "$.result");
					sb.append(String.join(":", acc, balance));
					sb.append("\n");
					sb.append(String.join(":", acc, HexUtil.fromHex(balance)));
					sb.append("\n");
					sb.append("\n");
				} catch (IOException e) {
					sb.append(e.getMessage());
				}
			});
			return sb.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
