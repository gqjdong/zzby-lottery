package com.welfare.ssq.supply.httprpc;

import com.zzby.httpclient.HttpClientManager;
import com.zzby.httpclient.HttpClientParam;
import com.zzby.httpclient.client.IHttpClient;

public enum HttpClientRpc {
	// 彩客网
	CAIKE(HttpRpcPropertiesHolder.PREFIX_CAIKE),

	// 幸运门
	LUCKYGATE(HttpRpcPropertiesHolder.PREFIX_LUCKYGATE),

	// 体坛
	TITAN(HttpRpcPropertiesHolder.PREFIX_TITAN);

	private String prefix;
	
	private IHttpClient httpClient;
	
	private IHttpClient httpsClient;
	
	private HttpClientRpc(String prefix) {
		this.prefix = prefix;
	}
	
	public synchronized IHttpClient getInstance(boolean isSafe) {
		if (isSafe) {
			if (httpsClient == null) {
				httpsClient = HttpClientManager.createClient(true);
				initClientFromParam(httpsClient,prefix);
			}
		} else {
			if (httpClient == null) {
				httpClient = HttpClientManager.createClient(false);
				initClientFromParam(httpClient,prefix);
			}
		}
		return isSafe ? httpsClient : httpClient;
	}
	
	/**
	 * 根据前缀不同，为不同的client初始化不同的配置
	 * @param client
	 * @param prefix
	 */
	private void initClientFromParam(IHttpClient client,String prefix){
		HttpClientParam param = new HttpClientParam();
		param.setSocketBufferSize(HttpRpcPropertiesHolder.getSocketBufferSize(prefix));
		param.setConnectionTimeout(HttpRpcPropertiesHolder.getConnectionTimeout(prefix));
		param.setSoTimeout(HttpRpcPropertiesHolder.getSoTimeout(prefix));
		param.setConnectionManagerTimeout(HttpRpcPropertiesHolder.getConnectionManagerTimeout(prefix));
		param.setRequestSentRetryEnabled(HttpRpcPropertiesHolder.isEnableConnectionRepeat(prefix));
		param.setRetryCount(HttpRpcPropertiesHolder.getConnectionRepeatCount(prefix));
		client.setHttpClientParam(param);
	}

	public IHttpClient getHttpClient() {
		return httpClient;
	}

	public IHttpClient getHttpsClient() {
		return httpsClient;
	}

	public String getPrefix() {
		return prefix;
	}

}
