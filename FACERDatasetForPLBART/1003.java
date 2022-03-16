	/**
	 * �����������ֹ���
	 * 
	 * @param duration
	 *            �����������ֹ��ܴ򿪳���������ֵΪ0��300֮���������
	 */
	public static void openDiscovery(int duration) {
		if (duration <= 0 || duration > 300) {
			duration = 200;
		}
		Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, duration);
	}

