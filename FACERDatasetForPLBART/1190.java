        @Override
        public void handleMessage(Message msg) {
            byte[] packet = (byte[]) msg.obj;
            int senderLength = msg.arg1;
            int senderId = msg.arg2;

            String sender = new String(Arrays.copyOfRange(packet, 0, senderLength));
            byte[] body = Arrays.copyOfRange(packet, senderLength, packet.length);

            boolean isSelf = senderId == id;

            switch (msg.what) {
                case MESSAGE_ID:
                    id = body[0];
                case MESSAGE_NAME:
                    if (!isHost && !isInitialized) {
                        String chatRoomName = new String(body);

                        if (mActivity.getActionBar() != null) {
                            mActivity.getActionBar().setTitle(chatRoomName);
                        }

                        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                        mProgressDialog.dismiss();

                        Toast.makeText(mActivity, mActivity.getString(R.string.connected), Toast.LENGTH_SHORT).show();

                        isInitialized = true;
                    }
                    break;
                case MESSAGE_SEND:
                    if (isHost) {
                        byte[] sendPacket = buildPacket(MESSAGE_SEND, senderId, sender, body);
                        writeMessage(sendPacket, senderId);
                    }
                    break;
                case MESSAGE_RECEIVE:
                    MessageBox messageBox = new MessageBox(sender, new String(body), new Date(), isSelf);
                    addMessage(messageBox);
                    break;
                case MESSAGE_SEND_IMAGE:
                    if (isHost) {
                        byte[] sendImagePacket = buildPacket(MESSAGE_SEND_IMAGE, senderId, sender, body);
                        writeMessage(sendImagePacket, senderId);
                    }
                    break;
                case MESSAGE_RECEIVE_IMAGE:
                    Bitmap bitmap = BitmapFactory.decodeByteArray(body, 0, body.length);
                    MessageBox imageBox = new MessageBox(sender, bitmap, new Date(), isSelf);
                    addMessage(imageBox);
            }
        }

