    @Override
    public byte[] assembleCommand() {
        int length = 0;
        if(data != null){
            length = 6 + data.length;
            dataLength = ConvertUtil.intToBytesHigh(data.length, 2);
        } else{
            length = 6;
            dataLength = ConvertUtil.intToBytesHigh(0, 2);
        }
        ByteBuffer buffer = ByteBuffer.allocate(length);
        buffer.put(startFlag);
        buffer.put(dataLength);
        buffer.put(protocolVersion);
        buffer.put(commandType);
        if(data != null){
            buffer.put(data);
        } else{
            buffer.put(new byte[0]);
        }
        byte[] checkData = new byte[length - 2];
        System.arraycopy(buffer.array(), 1, checkData, 0, length - 2);
        checkCode = CRCUtil.calcCrc8(checkData);
        buffer.put(checkCode);
        BleLog.i("send packet:"+ HexUtil.encodeHexStr(buffer.array()));
        return buffer.array();
    }

