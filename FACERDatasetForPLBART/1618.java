		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			try {
				mBA.cancelDiscovery();
				client = pairedDevices.get(position).createRfcommSocketToServiceRecord(MY_UUID);
				client.connect();
				out = (ObjectOutputStream) client.getOutputStream();
				in = (ObjectInputStream) client.getInputStream();
				Intent i = new Intent(BluetoothClientConnection.this,ChatActivity.class);
				i.putExtra("sendBy", "client");
				startActivity(i);
			} catch (IOException e) {e.printStackTrace();}
		}};

