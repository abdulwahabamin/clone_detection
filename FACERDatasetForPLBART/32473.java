    public void startSensorBasedUpdates() {
        receiversLock.lock();
        try {
            appendLog(getBaseContext(), TAG,
                    "Check if receivers is going to be started:  receiversRegistered=",
                    receiversRegistered);
            if (receiversRegistered) {
                return;
            }
            registerScreenListeners();
            startNetworkConnectivityReceiver();
            receiversRegistered = true;
        } finally {
            receiversLock.unlock();
        }
    }

