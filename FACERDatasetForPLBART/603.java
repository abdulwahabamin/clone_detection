    @Override
    public byte[] assembleCommand() {
        int length = 0;
        if(data != null){
            length = 2 + data.length;
        } else{
            length = 2;
        }
        ByteBuffer buffer = ByteBuffer.allocate(length);
        buffer.put(startFlag);
        if(data != null){
            buffer.put(data);
        } else{
            buffer.put(new byte[0]);
        }
        buffer.put(checkCode);
        BleLog.i("send packet:"+ HexUtil.encodeHexStr(buffer.array()));
        return buffer.array();
    }

