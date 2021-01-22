package com.binance.api.client.config;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfig {

	/**
	 * Base domain for URLs.
	 */
	private static String BASE_DOMAIN = "binance.com";

	/**
	 * Test domain for URLs.
	 */
	private static String TEST_DOMAIN = "testnet.binance.vision";

	/**
	 * Is test mode
	 */
	private static boolean isTestMode = false;

	/**
	 * Is test mode
	 */
	public static boolean isTestMode() {
		return isTestMode;
	}

	/**
	 * Set test mode
	 */
	public static boolean setTestMode(boolean bool) {
		isTestMode = bool;
		return isTestMode;
	}

	/**
	 * Set the URL base domain name (e.g., binance.com).
	 *
	 * @param baseDomain Base domain name
	 */
	public static void setBaseDomain(final String baseDomain) {
		BASE_DOMAIN = baseDomain;
	}

	/**
	 * Get the URL base domain name (e.g., binance.com).
	 *
	 * @return The base domain for URLs
	 */
	public static String getBaseDomain() {
		return isTestMode() ? TEST_DOMAIN : BASE_DOMAIN;
	}

	/**
	 * REST API base URL.
	 */
	public static String getApiBaseUrl() {
		String format = isTestMode() ? "https://%s" : "https://api.%s";
		return String.format(format, getBaseDomain());
	}

	/**
	 * Streaming API base URL.
	 */
	public static String getStreamApiBaseUrl() {
		String format = isTestMode() ? "wss://%s/ws" : "wss://stream.%s:9443/ws";
		return String.format("wss://stream.%s:9443/ws", getBaseDomain());
	}

	/**
	 * Asset info base URL.
	 */
	public static String getAssetInfoApiBaseUrl() {
		return String.format("https://%s/", getBaseDomain());
	}

}
