	@Override
	protected void onStart() {
		super.onStart();
		if(!mBA.isEnabled()){
			Intent enableBlue = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBlue,100);
		}
	}

