    @Override
    public void onAvailable(Network network) {
        super.onAvailable(network);
        appendLog(context, TAG, "onAvailable, network=", network, ", wasOffline=", wasOffline);
        if (networkIsOffline()) {
            appendLog(context, TAG, "network is offline");
            wasOffline = true;
            return;
        }
        appendLog(context, TAG, "network is online, wasOffline=", wasOffline);
        if (wasOffline) {
            checkAndUpdateWeather();
        }
        wasOffline = false;
    }

