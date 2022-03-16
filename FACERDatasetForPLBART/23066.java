	private boolean setWifiEnabled(boolean wifiEnabled) {
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		if (wifiManager != null)
			return wifiManager.setWifiEnabled(wifiEnabled);
		return false;
	}

