    public void writeMessage(byte[] byteArray, int senderId) {
        int type = byteArray[0];
        int receiveType = 0;
        if (type == MESSAGE_SEND) {
            receiveType = MESSAGE_RECEIVE;
        } else if (type == MESSAGE_SEND_IMAGE) {
            receiveType = MESSAGE_RECEIVE_IMAGE;
        }

        int senderLength = byteArray[1];

        int currIndex = 2;
        do {
            currIndex++;
        } while (byteArray[currIndex] != BODY_LENGTH_END_SIGNED);

        mHandler.obtainMessage(receiveType, senderLength, senderId, Arrays.copyOfRange(byteArray, currIndex + 2, byteArray.length))
                .sendToTarget();

        if (isHost) {
            new DistributeThread(receiveType, senderId, byteArray).start();
        } else {
            mConnectedThread.write(byteArray);
        }
    }

