package com.evan.deadmansswitch.data.model;

public enum Network {

    NONE_SELECTED(null, "Select Network", -1, null),
    TEST_NET("https://rpc.sepolia-api.lisk.com", "Lisk L2 Testnet", 4202, "https://sepolia-blockscout.lisk.com/address/");

    private final String baseUrl;
    private final String networkName;
    private final int chainId;
    private final String explorerUrl;

    Network(String baseUrl, String networkName, int chainId, String explorerUrl) {
        this.baseUrl = baseUrl;
        this.networkName = networkName;
        this.chainId = chainId;
        this.explorerUrl = explorerUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getNetworkName() {
        return networkName;
    }

    public int getChainId() {
        return chainId;
    }

    public String getExplorerUrl() {
        return explorerUrl;
    }
}
