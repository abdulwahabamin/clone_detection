    public static byte[] packMsg(String msg) throws UnsupportedEncodingException {
        if (msg == null || msg.isEmpty()) {
            return null;
        }
        return new ViseAssemble.Builder()
                .setCommandFlag(ChatConstant.VISE_COMMAND_TYPE_TEXT)
                .setData(msg.getBytes("UTF-8"))
                .assembleCommand();
    }

