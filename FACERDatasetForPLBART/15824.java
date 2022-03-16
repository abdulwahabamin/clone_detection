    public WifiP2pBroadcastReceiver(Context context, WifiP2pManager p2pManager,
                                    WifiP2pManager.Channel channel) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        context.registerReceiver(this, intentFilter);
        this.p2pManager = p2pManager;
        this.channel = channel;
    }

