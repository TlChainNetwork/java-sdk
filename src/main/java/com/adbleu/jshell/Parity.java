package com.tlchain.jshell;

import com.tlchain.rpc.eth.DeployContract;
import com.tlchain.rpc.eth.GetBalance;
import com.tlchain.rpc.eth.InvokeCall;
import com.tlchain.rpc.eth.SendEther;
import com.tlchain.rpc.eth.TraceCall;
import com.tlchain.rpc.personal.ListAccounts;
import com.tlchain.rpc.personal.NewAccount;
import com.tlchain.rpc.personal.UnlockAccount;
import com.tlchain.util.HexUtil;

public class Parity {

	public static void newAccount(String password) {
		System.out.println(new NewAccount().execute(password));
	}

	public static void listAccounts() {
		System.out.println(new ListAccounts().execute());
	}

	public static void unlockAccount(final String address, final String password, int durationInSecs) {
		System.out.println(new UnlockAccount().execute(address, password, durationInSecs));
	}

	public static void getBalance(final String address) {
		System.out.println(new GetBalance().execute(address));
	}

	public static void getAllBalances() {
		System.out.println(new GetBalance().execute());
	}

	public static void deployContract(final String fromAddress, final String password, int durationSecs, String gas,
			String gasValue, final String filePath, long sleepSecs) {
		System.out.println(
				new DeployContract().execute(fromAddress, password, durationSecs, gas, gasValue, filePath, sleepSecs));
	}

	public static void sendEther(final String fromAddress, final String password, final int durationSecs,
			final String toAddress, final String gas, final String gasPrice, final String ether) {

		System.out
				.println(new SendEther().execute(fromAddress, password, durationSecs, toAddress, gas, gasPrice, ether));

	}

	public static void invokeCall(final String fromAddress, String toAddress, final String encodedData) {

		System.out.println(new InvokeCall().execute(fromAddress, toAddress, encodedData));

	}

	public static void traceCall(final String fromAddress, String toAddress, final String encodedData) {

		System.out.println(new TraceCall().execute(fromAddress, toAddress, encodedData));

	}

	public static void fromHex(String hexValue) {
		System.out.println(HexUtil.fromHex(hexValue));
	}

	public static void toHex(String decValue) {
		System.out.println(HexUtil.toHex(decValue));
	}

	public static void abiAddress(String address) {
		System.out.println(HexUtil.abiAddress(address));
	}
}
