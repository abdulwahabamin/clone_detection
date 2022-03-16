        @Override
        public void writeData(byte[] data, int type) {
            if(data == null){
                LogUtils.e("writeData is Null or Empty!");
                return;
            }
            LogUtils.i("writeData:"+HexUtil.encodeHexStr(data));
        }

