	/**
	 * ���캯��
	 */
	public BluetoothClientConnThread(Handler handler,
			BluetoothDevice serverDevice) {
		this.serviceHandler = handler;
		this.serverDevice = serverDevice;
	}

