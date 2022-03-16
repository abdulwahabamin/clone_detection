	public void sendMess(String str){
		TransmitBean data = new TransmitBean();
		data.setMsg(str);
		Intent sendDataIntent = new Intent(
				BluetoothTools.ACTION_DATA_TO_SERVICE);
		sendDataIntent.putExtra(BluetoothTools.DATA, data);
		sendBroadcast(sendDataIntent);
	}

