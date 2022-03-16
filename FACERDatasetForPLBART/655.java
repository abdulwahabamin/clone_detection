    public static byte[] packFile(File file) throws UnsupportedEncodingException{
        if (file == null || file.getName() == null || file.getName().isEmpty()) {
            return null;
        }
        byte[] fNameBytes = file.getName().getBytes("UTF-8");
        ByteBuffer byteBuffer = ByteBuffer.allocate(fNameBytes.length + 6);
        byteBuffer.put(ConvertUtil.intToBytesHigh((int) file.length(), 4));
        byteBuffer.put(ConvertUtil.intToBytesHigh(fNameBytes.length, 2));
        byteBuffer.put(fNameBytes);
        return new ViseAssemble.Builder()
                .setCommandFlag(ChatConstant.VISE_COMMAND_TYPE_FILE)
                .setData(byteBuffer.array())
                .assembleCommand();
    }

