    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isSelf()) {
            return SELF_CHAT;
        } else {
            return FRIEND_CHAT;
        }
    }

