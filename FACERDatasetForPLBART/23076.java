	private boolean isWifiOn() {
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		if (wifiManager != null) {
			if (wifiManager.isWifiEnabled())
				return true;
		}
		return false;

	}

