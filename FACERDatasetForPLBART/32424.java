    @Override
    public void onCreate() {
        super.onCreate();
        mTelephonyManager = ((TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE));
        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        try {
            mWifiLock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_SCAN_ONLY, "SCAN_LOCK");
            if (!mWifiLock.isHeld()) {
                mWifiLock.acquire();
            }
        } catch (UnsupportedOperationException uoe) {
            appendLog(getBaseContext(), TAG,
                    "Unable to acquire wifi lock.", uoe);
        }
        registerReceiver(mReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

