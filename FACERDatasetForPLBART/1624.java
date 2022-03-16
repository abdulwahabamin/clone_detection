		@Override
		protected BluetoothSocket doInBackground(UUID... uuid) {
			BluetoothServerSocket bss;
			try {
				bss = mBA.listenUsingRfcommWithServiceRecord("BluetoothNikhil", uuid[0]);
				BluetoothSocket connected = bss.accept();
				if(connected!=null)
					bss.close();
				return connected;
			} catch (IOException e) {e.printStackTrace();}
			
			return null;
		}

