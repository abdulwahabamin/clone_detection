    /**
     * å¼€å§‹æ‰«æ??è“?ç‰™
     */
    private void startScan() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //android 5.0ä¹‹å‰?çš„æ‰«æ??æ–¹å¼?
            mBluetoothAdapter.startLeScan(new BluetoothAdapter.LeScanCallback() {
                @Override
                public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {

                }
            });
        } else {
            //android 5.0ä¹‹å?Žçš„æ‰«æ??æ–¹å¼?
            scanner = mBluetoothAdapter.getBluetoothLeScanner();

            scanCallback = new ScanCallback() {
                @Override
                public void onScanResult(int callbackType, ScanResult result) {

                    //å?œæ­¢æ‰«æ??
                    if (firstScan) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                scanner.stopScan(scanCallback);

                            }
                        }, SCAN_TIME);

                        firstScan = false;
                    }

                    String mac = result.getDevice().getAddress();

                    Log.i(TAG, result.getScanRecord().getDeviceName() + ":" + mac);
                    //è¿‡æ»¤é‡?å¤?çš„mac
                    if (!macSet.contains(mac)) {
                        macSet.add(result.getDevice().getAddress());
                        deviceList.add(result.getDevice());
                        deviceAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onBatchScanResults(List<ScanResult> results) {
                    Log.i(TAG, "batch scan result size:" + results.size());
                }

                @Override
                public void onScanFailed(int errorCode) {
                    super.onScanFailed(errorCode);
                    Log.e(TAG, "æ‰«æ??å¤±è´¥:" + errorCode);
                }
            };

            scanner.startScan(scanCallback);
        }

    }

