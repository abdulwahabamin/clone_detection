        public void run() {
            if (close)
            {
                close();
                return;
            }
            mmBuffer = new byte[1024];
            int numBytes; // bytes returned from read()
            Message readMsg;
            // Keep listening to the InputStream until an exception occurs.
            while (true) {
                try {
                    // Read from the InputStream.
                    numBytes = mmInStream.read(mmBuffer);
                    // Send the obtained bytes to the UI activity.

                    Utils.log("reading from buffer send to ui");

                    /*Message readMsg = mHandler.obtainMessage(
                            MessageConstants.MESSAGE_READ, numBytes, -1,
                            mmBuffer);*/

                    readMsg = new Message();
                    readMsg.what=MessageConstants.MESSAGE_READ;
                    readMsg.arg1=numBytes;
                    readMsg.obj=mmBuffer;


                    EventBus.getDefault().post(new MessageEvent(readMsg,name_other,macAddress,macAddress));

                    //storeMessage(readMsg);
                    Log.d(TAG, "run: readMsg is"+ new String(mmBuffer,0,numBytes));

                    //mmBuffer=new byte[1024];

                    //readMsg.sendToTarget();
                } catch (IOException e) {

                    close();
                    Log.d(TAG, "Input stream was disconnected", e);
                    break;
                }
            }
        }

