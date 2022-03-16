    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;  //getApplicationContext();
        WifiManager manager = (WifiManager) getSystemService( Context.WIFI_SERVICE );
        wifiLock = manager.createWifiLock( TAG );
        wifiLock.setReferenceCounted( false );
    }

