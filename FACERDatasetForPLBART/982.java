		@Override
		public void onReceive(Context context, Intent intent) {
			// ��ȡ�㲥��Action
			String action = intent.getAction();

			if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
			// ��ʼ����
			} else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// ����Զ�������豸
				// ��ȡ�豸
				BluetoothDevice bluetoothDevice = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

				String address = bluetoothDevice.getAddress();
				String name = bluetoothDevice.getName();
				Log.e("this bluetooth address", address);
				Log.e("this bluetooth name", name);
				
				//�������������ַƥ����ֻ��󣬷��͹㲥����ע���˸ù㲥��Receiver�������Ӳ���
//				if (address.equals(BluetoothTools.BluetoothAddress)	|| address.equals(BluetoothTools.BluetoothAddress2)) 
				if(verify(address) || address.equals(bluetoothAdapter.getAddress()))
				{
					TempB = true;
					bluetoothAdapter.cancelDiscovery();// ȡ������
					// ���㲥���ͳ�ȥ
					Intent selectDeviceIntent = new Intent(
							BluetoothTools.ACTION_SELECTED_DEVICE);
					selectDeviceIntent.putExtra(BluetoothTools.DEVICE,
							bluetoothDevice);
					sendBroadcast(selectDeviceIntent);
				}

			} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED
					.equals(action)) {
				// ���������������������ȡ�����������ͷ��͹㲥
				if (!TempB) {
					// ��δ�ҵ��豸���򷢶�δ�����豸�㲥
					Intent foundIntent = new Intent(
							BluetoothTools.ACTION_NOT_FOUND_SERVER);
					sendBroadcast(foundIntent);
				}
			} else if (BluetoothTools.ACTION_NOT_FOUND_SERVER.equals(action)) {
				// ������ɣ�δ�����豸��������������
				bluetoothAdapter.cancelDiscovery();// ȡ������
				try {
					Thread.sleep(5000);// ����,��ֹ�Ͷ��ֻ�����
				} catch (Exception e) {
					Log.e("sleep", e.getMessage());
				}
				bluetoothAdapter.startDiscovery(); // ��ʼ����
			}
		}

