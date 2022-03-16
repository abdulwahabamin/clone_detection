		@Override
		protected void onPostExecute(BluetoothSocket socket) {
			if(socket == null) return;
			try {
				out = (ObjectOutputStream) socket.getOutputStream();
				in = (ObjectInputStream) socket.getInputStream();
				Intent i = new Intent(BluetoothServerConnection.this,ChatActivity.class);
				i.putExtra("sendBy", "server");
				startActivity(i);
			} catch (IOException e) {e.printStackTrace();}
		}

