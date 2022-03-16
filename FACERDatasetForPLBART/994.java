	@Override
	public void run() {

		try {
			Thread.sleep(1000);//休眠1秒，防止出错
			
			serverSocket = adapter.listenUsingRfcommWithServiceRecord("Server",
					BluetoothTools.PRIVATE_UUID);
			socket = serverSocket.accept();
		} catch (Exception e) {
			// 发送连接失败消息
			serviceHandler.obtainMessage(BluetoothTools.MESSAGE_CONNECT_ERROR)
					.sendToTarget();
			e.printStackTrace();
			// 打印连接失败信息
			Log.e("BluetoothServerConnThread,e=", e.getMessage());
			// System.out.println("BluetoothServerConnThread,e="+e.getMessage());
			return;
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
				// 打印关闭socket失败信息
				Log.e("close socket,e=", e.getMessage());
				// System.out.println("close socket,e="+e.getMessage());
			}
		}
		try {
			if (socket != null) {
				// 发送连接成功消息，消息的obj字段为连接的socket
				Message msg = serviceHandler.obtainMessage();
				msg.what = BluetoothTools.MESSAGE_CONNECT_SUCCESS;
				msg.obj = socket;
				msg.sendToTarget();
			} else {
				// 发送连接失败消息
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

