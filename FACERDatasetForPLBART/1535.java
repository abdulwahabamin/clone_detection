        public void run() {
            Log.i(TAG, "BEGIN mConnectedThread");
            byte[] buffer = new byte[1024];
            int bytes;
            // Keep listening to the InputStream while connected
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = mmInStream.read(buffer);
                    // Send the obtained bytes to the UI Activity
                    final String readMessage = new String(buffer, 0, bytes);
                    Log.i(TAG,"Listening "+readMessage);
                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    if(readMessage!=null)
                                        messages.setText(messages.getText()+"\n"+readMessage);
                                }
                            }
                    );
                } catch (Exception e) {
                    Log.e(TAG, "disconnected", e);
                    //connectionLost();
                    //break;
                }
            }
        }

