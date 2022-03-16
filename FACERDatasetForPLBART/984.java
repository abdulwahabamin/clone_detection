		@Override
		public void handleMessage(Message msg) {
			// 处理消息
			switch (msg.what) {
			case BluetoothTools.MESSAGE_CONNECT_ERROR:
				// 连接错误
				// 发送连接错误广播
				Intent errorIntent = new Intent(
						BluetoothTools.ACTION_CONNECT_ERROR);
				sendBroadcast(errorIntent);
				break;
			case BluetoothTools.MESSAGE_CONNECT_SUCCESS:
				// 连接成功

				// 开启通讯线程
				communThread = new BluetoothCommunThread(handler,
						(BluetoothSocket) msg.obj);
				communThread.start();

				// 发送连接成功广播
				Intent succIntent = new Intent(
						BluetoothTools.ACTION_CONNECT_SUCCESS);
				sendBroadcast(succIntent);
				break;
			case BluetoothTools.MESSAGE_READ_OBJECT:
				// 读取到对象
				// 发送数据广播（包含数据对象）
				Intent dataIntent = new Intent(
						BluetoothTools.ACTION_DATA_TO_GAME);
				dataIntent
						.putExtra(BluetoothTools.DATA, (Serializable) msg.obj);
				sendBroadcast(dataIntent);
				break;
			}
			super.handleMessage(msg);
		}

