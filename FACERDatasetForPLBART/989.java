	/**
	 * Service����ʱ�Ļص�����
	 */
	@Override
	public void onDestroy() {
		if (communThread != null) {
			communThread.isRun = false;
		}
		// �����
		unregisterReceiver(discoveryReceiver);
		bluetoothAdapter.disable();// �ر�����
		super.onDestroy();
	}

