    	CopyEngine( Handler h ) {
    		super( h );
    		startTime = System.currentTimeMillis();
            WifiManager manager = (WifiManager)FTPAdapter.this.ctx.getSystemService( Context.WIFI_SERVICE );
            wifiLock = manager.createWifiLock( TAG );
            wifiLock.setReferenceCounted( false );
    	}

