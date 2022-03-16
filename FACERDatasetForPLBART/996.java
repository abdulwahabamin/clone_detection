		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case BluetoothTools.MESSAGE_CONNECT_SUCCESS:
				// ���ӳɹ�
				// ����ͨѶ�߳�
				communThread = new BluetoothCommunThread(serviceHandler,
						(BluetoothSocket) msg.obj);
				communThread.start();

				// �������ӳɹ���Ϣ
				Intent connSuccIntent = new Intent(
						BluetoothTools.ACTION_CONNECT_SUCCESS);
				sendBroadcast(connSuccIntent);
				break;

			case BluetoothTools.MESSAGE_CONNECT_ERROR:
				// ���Ӵ���
				// �������Ӵ���㲥
				Intent errorIntent = new Intent(
						BluetoothTools.ACTION_CONNECT_ERROR);
				sendBroadcast(errorIntent);
				break;

			case BluetoothTools.MESSAGE_READ_OBJECT:
				// ��ȡ������
				// �������ݹ㲥���������ݶ���
				Intent dataIntent = new Intent(
						BluetoothTools.ACTION_DATA_TO_GAME);
				dataIntent
						.putExtra(BluetoothTools.DATA, (Serializable) msg.obj);
				sendBroadcast(dataIntent);

				break;
			}

			super.handleMessage(msg);
		}

