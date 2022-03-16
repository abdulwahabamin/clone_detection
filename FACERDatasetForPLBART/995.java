		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (BluetoothTools.ACTION_STOP_SERVICE.equals(action)) {
				// ֹͣ��̨����
				if (communThread != null) {
					communThread.isRun = false;
				}
				stopSelf();

			} else if (BluetoothTools.ACTION_DATA_TO_SERVICE.equals(action)) {
				// ��������
				Object data = intent.getSerializableExtra(BluetoothTools.DATA);
				if (communThread != null) {
					communThread.writeObject(data);
				}

			}
		}

