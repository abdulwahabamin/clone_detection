	public void openExternal(View view) {
		Intent intent = new Intent(this, DisplayDirectoryActivity.class);
		// Need a method for external card, rather than hard coding
		
		intent.putExtra("currentPath", "/storage/sdcard1" + "");
		startActivity(intent);
	}

