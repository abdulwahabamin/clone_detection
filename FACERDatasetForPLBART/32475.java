    private void startNetworkConnectivityReceiver() {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                appendLog(getBaseContext(), TAG, "Start connectivity receiver with handler");
                networkConnectivityReceiver = new NetworkConnectivityReceiver();
                IntentFilter filterNetworkConnectivity = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
                getApplicationContext().registerReceiver(networkConnectivityReceiver, filterNetworkConnectivity);
            } else {
                appendLog(getBaseContext(), TAG, "Start connectivity receiver with callback");
                ConnectivityManager connectivityManager
                        = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                networkConnectionReceiver = new NetworkConnectionReceiver(this);
                connectivityManager.registerDefaultNetworkCallback(networkConnectionReceiver);
            }
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, e);
        }
    }

