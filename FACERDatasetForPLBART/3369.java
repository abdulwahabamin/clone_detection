	@TargetApi(19)
	public static double getSdSize() {
		StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
		try {
			double sdAvailSize = (double) stat.getBlockCountLong() * (double) stat.getBlockSizeLong();
//One binary gigabyte equals 1,073,741,824 bytes.
			double gigaAvailable = sdAvailSize / 1073741824;
			return gigaAvailable;
		}catch(java.lang.NoSuchMethodError e) {}
		return 0;
	}

