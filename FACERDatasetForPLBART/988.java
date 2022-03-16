	/**
	 * Service创建时的回调函数
	 */
	@Override
	public void onCreate() {
		// discoveryReceiver的IntentFilter
		IntentFilter discoveryFilter = new IntentFilter();
		discoveryFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		discoveryFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		discoveryFilter.addAction(BluetoothDevice.ACTION_FOUND);
		discoveryFilter.addAction(BluetoothTools.ACTION_NOT_FOUND_SERVER);

		// controlReceiver的IntentFilter
		IntentFilter controlFilter = new IntentFilter();
		controlFilter.addAction(BluetoothTools.ACTION_SELECTED_DEVICE);
		controlFilter.addAction(BluetoothTools.ACTION_STOP_SERVICE);
		controlFilter.addAction(BluetoothTools.ACTION_DATA_TO_SERVICE);

		// 注册BroadcastReceiver
		registerReceiver(discoveryReceiver, discoveryFilter);
		registerReceiver(controlReceiver, controlFilter);

		discoveredDevices.clear(); // 清空存放设备的集合
		bluetoothAdapter.enable(); // 打开蓝牙
		try {
			Thread.sleep(5000);// 休眠1秒
		} catch (Exception e) {
			Log.e("sleep", e.getMessage());
		}
		bluetoothAdapter.startDiscovery(); // 开始搜索
		super.onCreate();
	}

