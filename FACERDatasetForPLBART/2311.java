	void launchApplication(int pos) {
		Intent intent = new Intent();
		intent.setAction(mIntentAction[pos]);
		if (mIntentAction[pos].equals(Intent.ACTION_MAIN)) {
			// Exception for ACTION_MAIN:
			// Use data as class name.
			if (mPackageNames[pos] != null && mIntentData[pos] != null) {
				intent.setClassName(mPackageNames[pos], mIntentData[pos]);
			}
		} else {
			if (mIntentData[pos] != null) {
				intent.setData(Uri.parse(mIntentData[pos]));
			}
		}
		
		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {

			Toast.makeText(this,
					R.string.oi_distribution_launch_error,
					Toast.LENGTH_SHORT).show();
		}
	}

