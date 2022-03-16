		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (BluetoothTools.ACTION_SELECTED_DEVICE.equals(action)) {
				// ѡ�������ӵķ������豸
				BluetoothDevice device = (BluetoothDevice) intent.getExtras()
						.get(BluetoothTools.DEVICE);
				// �����豸�����߳�
				new BluetoothClientConnThread(handler, device).start();
			} else if (BluetoothTools.ACTION_STOP_SERVICE.equals(action)) {
				// ֹͣ��̨����
				if (communThread != null) {
					communThread.isRun = false;
				}
				stopSelf();
			} else if (BluetoothTools.ACTION_DATA_TO_SERVICE.equals(action)) {
				// ��ȡ����
				Object data = intent.getSerializableExtra(BluetoothTools.DATA);
				if (communThread != null) {
					communThread.writeObject(data);
				}
			}
		}

