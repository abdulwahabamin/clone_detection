		@Override
		public void onReceive(Context context, Intent intent) {
			// 获取广播的Action
			String action = intent.getAction();

			if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
			// 开始搜索
			} else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// 发现远程蓝牙设备
				// 获取设备
				BluetoothDevice bluetoothDevice = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

				String address = bluetoothDevice.getAddress();
				String name = bluetoothDevice.getName();
				Log.e("this bluetooth address", address);
				Log.e("this bluetooth name", name);
				
				//这里搜索到与地址匹配的手机后，发送广播，由注册了该广播的Receiver进行连接操作
//				if (address.equals(BluetoothTools.BluetoothAddress)	|| address.equals(BluetoothTools.BluetoothAddress2)) 
				if(verify(address) || address.equals(bluetoothAdapter.getAddress()))
				{
					TempB = true;
					bluetoothAdapter.cancelDiscovery();// 取消搜索
					// 将广播发送出去
					Intent selectDeviceIntent = new Intent(
							BluetoothTools.ACTION_SELECTED_DEVICE);
					selectDeviceIntent.putExtra(BluetoothTools.DEVICE,
							bluetoothDevice);
					sendBroadcast(selectDeviceIntent);
				}

			} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
					.equals(action)) {
				// 搜索结束，如果不是主动取消的搜索，就发送广播
				if (!TempB) {
					// 若未找到设备，则发动未发现设备广播
					Intent foundIntent = new Intent(
							BluetoothTools.ACTION_NOT_FOUND_SERVER);
					sendBroadcast(foundIntent);
				}
			} else if (BluetoothTools.ACTION_NOT_FOUND_SERVER.equals(action)) {
				// 搜索完成，未发现设备，继续调用搜索
				bluetoothAdapter.cancelDiscovery();// 取消搜索
				try {
					Thread.sleep(5000);// 休眠,防止低端手机出错
				} catch (Exception e) {
					Log.e("sleep", e.getMessage());
				}
				bluetoothAdapter.startDiscovery(); // 开始搜索
			}
		}

