    private static boolean isRightCommand(byte[] data){
        if (data == null || data.length < 6) {
            return false;
        }
        byte[] lengthData = new byte[]{data[1], data[2]};
        byte[] lengthCurrent = ConvertUtil.intToBytesHigh(data.length-6, 2);
        byte[] checkData = new byte[data.length - 2];
        System.arraycopy(data, 1, checkData, 0, data.length - 2);
        byte checkCode = CRCUtil.calcCrc8(checkData);
        return (data[0] == (byte) 0xFF) && (Arrays.equals(lengthData, lengthCurrent)) && (data[data.length-1] == checkCode);
    }

