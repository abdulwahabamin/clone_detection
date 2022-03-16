                @Override
                public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
                    runOnUiThread(new Runnable() {
                        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {


//                            String decodedRecord = "";
//                            try {
//                                decodedRecord = new String(scanRecord,"UTF-8");
//
//                            } catch (UnsupportedEncodingException e) {
//                                e.printStackTrace();
//                            }
                            for (int i = 0; i < mLeDeviceListAdapter.getCount(); i++) {

                                Log.d("device_type", "run: " + device);
                            }
                            mLeDeviceListAdapter.addDevice(device);
                            mLeDeviceListAdapter.notifyDataSetChanged();


                        }
                    });
                }

