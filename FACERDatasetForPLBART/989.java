	/**
	 * Service销毁时的回调函数
	 */
	@Override
	public void onDestroy() {
		if (communThread != null) {
			communThread.isRun = false;
		}
		// 解除绑定
		unregisterReceiver(discoveryReceiver);
		bluetoothAdapter.disable();// 关闭蓝牙
		super.onDestroy();
	}

