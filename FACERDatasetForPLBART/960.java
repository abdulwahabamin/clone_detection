		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			
			if (BluetoothTools.ACTION_NOT_FOUND_SERVER.equals(action)) {
				// 未发现设备
				serversText.append("未发现设备" + count + "次\r\n");
				count++;
			} else if (BluetoothTools.ACTION_FOUND_DEVICE.equals(action)) {
				// 获取到设备对象
				BluetoothDevice device = (BluetoothDevice) intent.getExtras()
						.get(BluetoothTools.DEVICE);

				String address = device.getAddress();
				String name = device.getName();
				Log.e("add+name2", "address="+address+",name="+name);
				
//				if (address.equals(BluetoothTools.MEIZU_M9)
//						|| address.equals(BluetoothTools.HTC_Wildfire)
//						|| address.equals(BluetoothTools.Nexus_S)) {
//					deviceList.add(device);
//					serversText.append(device.getName() + "\r\n");
//				}
			} else if (BluetoothTools.ACTION_CONNECT_SUCCESS.equals(action)) {
				// 连接成功
				serversText.append("连接成功");
//				sendBtn.setEnabled(true);

			} else if (BluetoothTools.ACTION_DATA_TO_GAME.equals(action)) {
				// 接收数据
				TransmitBean data = (TransmitBean) intent.getExtras()
						.getSerializable(BluetoothTools.DATA);
				String msg = "服务端：" +"  "+ new Date().toLocaleString()
						+ " :\r\n" + data.getMsg() + "\r\n";
				chatEditText.append(msg);

			}else if(BluetoothTools.ACTION_CONNECT_ERROR.equals(action)){
				chatEditText.append("连接失败");
			}
		}

