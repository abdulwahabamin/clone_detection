	@Override
	public void onCreate() {
		// ControlReceiver��IntentFilter
		IntentFilter controlFilter = new IntentFilter();
		controlFilter.addAction(BluetoothTools.ACTION_START_SERVER);
		controlFilter.addAction(BluetoothTools.ACTION_STOP_SERVICE);
		controlFilter.addAction(BluetoothTools.ACTION_DATA_TO_SERVICE);

		// ע��BroadcastReceiver
		registerReceiver(controlReceiver, controlFilter);

		// ����������
		bluetoothAdapter.enable(); // ������
		// �����������ֹ��ܣ�300�룩
		Intent discoveryIntent = new Intent(
				BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,
				300);
		discoveryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(discoveryIntent);
		try{
			Thread.sleep(1000);//����1�룬��ֹ����
		}catch(Exception e){
			Log.e("sleep", e.getMessage());
		}
		// ������̨�����߳�
		new BluetoothServerConnThread(serviceHandler).start();

		super.onCreate();
	}

