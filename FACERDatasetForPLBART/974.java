		@Override
		public void onReceive(Context context, Intent intent) {

			String action = intent.getAction();

			if (BluetoothTools.ACTION_DATA_TO_GAME.equals(action)) {
				// ��������
				TransmitBean data = (TransmitBean) intent.getExtras()
						.getSerializable(BluetoothTools.DATA);
				String msg = "�ͻ��ˣ�" +"  " + new Date().toLocaleString()
						+ " :\r\n" + data.getMsg() + "\r\n";
				msgEditText.append(msg);

			} else if (BluetoothTools.ACTION_CONNECT_SUCCESS.equals(action)) {
				// ���ӳɹ�
				serverStateTextView.setText("���ӳɹ�");
//				sendBtn.setEnabled(true);
			}else if(BluetoothTools.ACTION_CONNECT_ERROR.equals(action)){
				//����ʧ��
				serverStateTextView.setText("����ʧ��");
			}

		}

