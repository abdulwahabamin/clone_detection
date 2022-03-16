    private void sendMessage() {
        ChatInfo chatInfo = new ChatInfo();
        FriendInfo friendInfo = new FriendInfo();
        friendInfo.setBluetoothDevice(mBluetoothChatHelper.getAdapter().getRemoteDevice(mBluetoothChatHelper.getAdapter().getAddress()));
        friendInfo.setOnline(true);
        friendInfo.setFriendNickName(mBluetoothChatHelper.getAdapter().getName());
        friendInfo.setIdentificationName(mBluetoothChatHelper.getAdapter().getName());
        friendInfo.setDeviceAddress(mBluetoothChatHelper.getAdapter().getAddress());
        chatInfo.setFriendInfo(friendInfo);
        chatInfo.setSend(true);
        chatInfo.setSendTime(DateTime.getStringByFormat(new Date(), DateTime.DEFYMDHMS));
        BaseMessage message = null;
        if(mIsSendFile){
            message = new FileMessage();
            message.setMsgType(ChatConstant.VISE_COMMAND_TYPE_FILE);
            message.setMsgContent(mMsgEditEt.getText().toString());
            message.setMsgLength(mMsgEditEt.getText().length());
            if(mSendFile != null){
                ((FileMessage)message).setFileLength((int) mSendFile.length());
                ((FileMessage)message).setFileName(mSendFile.getName());
            }
            if(mFilePath != null){
                ((FileMessage)message).setFileNameLength(mFilePath.length());
            }
        } else{
            message = new BaseMessage();
            message.setMsgType(ChatConstant.VISE_COMMAND_TYPE_TEXT);
            message.setMsgContent(mMsgEditEt.getText().toString());
            message.setMsgLength(mMsgEditEt.getText().length());
        }
        chatInfo.setMessage(message);
        mChatInfoList.add(chatInfo);
        mChatAdapter.setListAll(mChatInfoList);
        mMsgEditEt.setText("");
        try {
            if(mIsSendFile && mSendFile != null){
                mBluetoothChatHelper.write(CommandHelper.packFile(mSendFile));
                mIsSendFile = false;
                //è°ƒç”¨ç³»ç»Ÿç¨‹åº?å?‘é€?æ–‡ä»¶
                String uri = "file://" + mFilePath;
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("*/*");
                sharingIntent.setComponent(new ComponentName("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity"));
                sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(uri));
                startActivityForResult(sharingIntent, 1);
            } else{
                mBluetoothChatHelper.write(CommandHelper.packMsg(message.getMsgContent()));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

