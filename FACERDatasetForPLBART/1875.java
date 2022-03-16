        public void write(String msg) {
            try {
                mmOutStream.write(msg.getBytes());
                // Share the sent message with the UI activity.
                /*Message writtenMsg = mHandler.obtainMessage(
                        MessageConstants.MESSAGE_WRITE, -1, -1,msg.getBytes());*/
                //writtenMsg.sendToTarget();
                writtenMsg = new Message();
                writtenMsg.what=MessageConstants.MESSAGE_WRITE;
                writtenMsg.arg1=-1;
                writtenMsg.obj=msg.getBytes();

                EventBus.getDefault().post(new MessageEvent(writtenMsg,name_other,macAddress_my, macAddress));
                //storeMessage(writtenMsg);
                Log.d(TAG, "write: writenmsg is"+writtenMsg.toString());
            } catch (IOException e) {
                Log.e(TAG, "Error occurred when sending data", e);
                // Send a failure message back to the activity.
//                Message writeErrorMsg =
//                        mHandler.obtainMessage(MessageConstants.MESSAGE_TOAST);
//                Bundle bundle = new Bundle();
//                bundle.putString("toast",
//                        "Couldn't send data to the other device");
//                writeErrorMsg.setData(bundle);
                //writeErrorMsg.sendToTarget();
                //mHandler.sendMessage(writeErrorMsg);
                close();
            }
        }

