    protected void onActivityResult (int requestCode,
            int resultCode,
            Intent data) {

		if (resultCode == DISCOVER_DURATION
			&& requestCode == REQUEST_BLU) {
			Toast.makeText(this, "Bluetooth completed", Toast.LENGTH_SHORT).show();
			// processing code goes here
		} else { // cancelled or error
			Toast.makeText(this, "Bluetooth cancelled", Toast.LENGTH_SHORT).show();
		}
		super.onBackPressed();
	}

