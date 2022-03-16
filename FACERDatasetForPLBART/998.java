	@Override
	public void onCreate() {
		// ControlReceiver的IntentFilter
		IntentFilter controlFilter = new IntentFilter();
		controlFilter.addAction(BluetoothTools.ACTION_START_SERVER);
		controlFilter.addAction(BluetoothTools.ACTION_STOP_SERVICE);
		controlFilter.addAction(BluetoothTools.ACTION_DATA_TO_SERVICE);

		// 注册BroadcastReceiver
		registerReceiver(controlReceiver, controlFilter);

		// 开启服务器
		bluetoothAdapter.enable(); // 打开蓝牙
		// 开启蓝牙发现功能（300秒）
		Intent discoveryIntent = new Intent(
				BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,
				300);
		discoveryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(discoveryIntent);
		try{
			Thread.sleep(1000);//休眠1秒，防止出错
		}catch(Exception e){
			Log.e("sleep", e.getMessage());
		}
		// 开启后台连接线程
		new BluetoothServerConnThread(serviceHandler).start();

		super.onCreate();
	}

