    public static BaseMessage unpackData(byte[] data) throws UnsupportedEncodingException{
        BaseMessage message = null;
        if (data == null) {
            return null;
        }
        if(isRightCommand(data)){
            if(data[4] == ChatConstant.VISE_COMMAND_TYPE_TEXT){
                message = new BaseMessage();
                int dataLength = ConvertUtil.bytesToIntHigh(new byte[]{data[1], data[2]}, 0);
                byte[] msgData = new byte[dataLength];
                System.arraycopy(data, 5, msgData, 0, dataLength);
                if(msgData.length < 1) {
                    return message;
                }
                message.setMsgType(ChatConstant.VISE_COMMAND_TYPE_TEXT);
                message.setMsgLength(dataLength);
                message.setMsgContent(new String(msgData));
            } else if(data[4] == ChatConstant.VISE_COMMAND_TYPE_FILE){
                message = new FileMessage();
                int dataLength = ConvertUtil.bytesToIntHigh(new byte[]{data[1], data[2]}, 0);
                byte[] fileInfoData = new byte[dataLength];
                System.arraycopy(data, 5, fileInfoData, 0, dataLength);
                if(fileInfoData.length < 7){
                    return message;
                }
                byte[] fileLength = new byte[]{fileInfoData[0], fileInfoData[1], fileInfoData[2], fileInfoData[3]};
                byte[] fileNameLength = new byte[]{fileInfoData[4], fileInfoData[5]};
                byte[] fileName = new byte[fileInfoData.length - 6];
                System.arraycopy(fileInfoData, 6, fileName, 0, fileName.length);
                message.setMsgType(ChatConstant.VISE_COMMAND_TYPE_FILE);
                ((FileMessage)message).setFileLength(ConvertUtil.bytesToIntHigh(fileLength, 4));
                ((FileMessage)message).setFileName(new String(fileName));
                ((FileMessage)message).setFileNameLength(ConvertUtil.bytesToIntHigh(fileNameLength, 2));
            } else{
                message = new BaseMessage();
                message.setMsgType(ChatConstant.VISE_COMMAND_TYPE_NONE);
                message.setMsgLength(0);
                message.setMsgContent("");
            }
        }
        return message;
    }

