    public CustomAdapterForChat(ArrayList<ChatModel> data, Context context) {
        super(context, R.layout.list_item_for_sender_message, data);
        this.dataSet = data;
        this.mContext=context;

    }

