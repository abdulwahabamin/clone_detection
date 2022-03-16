    @Override
    public void HelpConvert(HelperViewHolder viewHolder, int position, ChatInfo chatInfo) {
        if (chatInfo == null) {
            return;
        }
        TextView timeTv;
        TextView msgTv;
        TextView nameTv;
        if(chatInfo.isSend()){
            timeTv = viewHolder.getView(R.id.item_chat_right_time);
            msgTv = viewHolder.getView(R.id.item_chat_right_msg);
            nameTv = viewHolder.getView(R.id.item_chat_right_name);
            timeTv.setText(chatInfo.getSendTime());
        } else{
            timeTv = viewHolder.getView(R.id.item_chat_left_time);
            msgTv = viewHolder.getView(R.id.item_chat_left_msg);
            nameTv = viewHolder.getView(R.id.item_chat_left_name);
            timeTv.setText(chatInfo.getReceiveTime());
        }
        if(chatInfo.getMessage() != null){
            if(chatInfo.getMessage().getMsgType() == ChatConstant.VISE_COMMAND_TYPE_FILE){
                if(chatInfo.isSend()){
                    msgTv.setText("�?��?文件："+((FileMessage)chatInfo.getMessage()).getFileName());
                } else{
                    msgTv.setText("接收文件："+((FileMessage)chatInfo.getMessage()).getFileName());
                }
            } else{
                msgTv.setText(chatInfo.getMessage().getMsgContent());
            }
        }
        if(chatInfo.getFriendInfo() != null){
            nameTv.setText(chatInfo.getFriendInfo().getFriendNickName());
        }
    }

