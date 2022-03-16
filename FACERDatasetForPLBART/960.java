		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			
			if (BluetoothTools.ACTION_NOT_FOUND_SERVER.equals(action)) {
				// δ�����豸
				serversText.append("δ�����豸" + count + "��\r\n");
				count++;
			} else if (BluetoothTools.ACTION_FOUND_DEVICE.equals(action)) {
				// ��ȡ���豸����
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
				// ���ӳɹ�
				serversText.append("���ӳɹ�");
//				sendBtn.setEnabled(true);

			} else if (BluetoothTools.ACTION_DATA_TO_GAME.equals(action)) {
				// ��������
				TransmitBean data = (TransmitBean) intent.getExtras()
						.getSerializable(BluetoothTools.DATA);
				String msg = "����ˣ�" +"  "+ new Date().toLocaleString()
						+ " :\r\n" + data.getMsg() + "\r\n";
				chatEditText.append(msg);

			}else if(BluetoothTools.ACTION_CONNECT_ERROR.equals(action)){
				chatEditText.append("����ʧ��");
			}
		}

