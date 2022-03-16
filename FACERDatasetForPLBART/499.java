        @Override
        public void readData(byte[] data, int type) {
            if(data == null){
                LogUtils.e("readData is Null or Empty!");
                return;
            }
            LogUtils.i("readData:"+HexUtil.encodeHexStr(data));
            try {
                BaseMessage message = CommandHelper.unpackData(data);
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setMessage(message);
                chatInfo.setReceiveTime(DateTime.getStringByFormat(new Date(), DateTime.DEFYMDHMS));
                chatInfo.setSend(false);
                chatInfo.setFriendInfo(mFriendInfo);
                mChatInfoList.add(chatInfo);
                mChatAdapter.setListAll(mChatInfoList);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

