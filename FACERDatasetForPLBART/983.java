		public boolean verify(String address) {
			boolean result = false;
//			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();   
			Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
			if(devices.size()>0){
				for(Iterator iterator = devices.iterator();iterator.hasNext();){
					BluetoothDevice device = (BluetoothDevice) iterator.next();
					if(address.equals(device.getAddress())){
						result = true;
						break;
					}
					System.out.println("����Ե��豸��"+device.getAddress());
				}
			}  
			return result;
		}

