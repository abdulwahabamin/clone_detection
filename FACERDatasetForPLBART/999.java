	@Override
	public void onDestroy() {
		if (communThread != null) {
			communThread.isRun = false;
		}
		unregisterReceiver(controlReceiver);
		bluetoothAdapter.disable();// �ر�����
		super.onDestroy();
	}

