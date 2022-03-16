    @Override
    public int getItemViewType ( int position){
        if (list.get(position) instanceof String) {
            return STATUS_MESSAGE;
        }

        if (((Message) list.get(position)).user_mac.equals(MY_MAC)) {
            return SELF;
        }
        return OTHER;
    }

