	@Override
	public void run() {

		try {
			Thread.sleep(1000);//����1�룬��ֹ����
			
			serverSocket = adapter.listenUsingRfcommWithServiceRecord("Server",
					BluetoothTools.PRIVATE_UUID);
			socket = serverSocket.accept();
		} catch (Exception e) {
			// ��������ʧ����Ϣ
			serviceHandler.obtainMessage(BluetoothTools.MESSAGE_CONNECT_ERROR)
					.sendToTarget();
			e.printStackTrace();
			// ��ӡ����ʧ����Ϣ
			Log.e("BluetoothServerConnThread,e=", e.getMessage());
			// System.out.println("BluetoothServerConnThread,e="+e.getMessage());
			return;
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
				// ��ӡ�ر�socketʧ����Ϣ
				Log.e("close socket,e=", e.getMessage());
				// System.out.println("close socket,e="+e.getMessage());
			}
		}
		try {
			if (socket != null) {
				// �������ӳɹ���Ϣ����Ϣ��obj�ֶ�Ϊ���ӵ�socket
				Message msg = serviceHandler.obtainMessage();
				msg.what = BluetoothTools.MESSAGE_CONNECT_SUCCESS;
				msg.obj = socket;
				msg.sendToTarget();
			} else {
				// ��������ʧ����Ϣ
				serviceHandler.obtainMessage(
						BluetoothTools.MESSAGE_CONNECT_ERROR).sendToTarget();
				Log.e("e", "socket=null");
				// System.out.println("socket=null");
				return;
			}
		} catch (Exception e) {
			Log.e("socket,e", e.getMessage());
		}
	}

