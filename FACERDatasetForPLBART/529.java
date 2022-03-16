    @Override
    public int checkLayout(int position, ChatInfo item) {
        if(item != null && item.isSend()){
            return 1;
        }
        return 0;
    }

