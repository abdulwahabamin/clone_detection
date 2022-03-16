		@Override
		public void onReceive(Context context, Intent intent) {

			String action = intent.getAction();

			if (BluetoothTools.ACTION_DATA_TO_GAME.equals(action)) {
				// 接收数据
				TransmitBean data = (TransmitBean) intent.getExtras()
						.getSerializable(BluetoothTools.DATA);
				String msg = "客户端：" +"  " + new Date().toLocaleString()
						+ " :\r\n" + data.getMsg() + "\r\n";
				msgEditText.append(msg);

			} else if (BluetoothTools.ACTION_CONNECT_SUCCESS.equals(action)) {
				// 连接成功
				serverStateTextView.setText("连接成功");
//				sendBtn.setEnabled(true);
			}else if(BluetoothTools.ACTION_CONNECT_ERROR.equals(action)){
				//连接失败
				serverStateTextView.setText("连接失败");
			}

		}

