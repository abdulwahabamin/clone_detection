    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType==STATUS_MESSAGE)
        {
            return new StatusHolder(LayoutInflater.from(ctx).inflate(R.layout.chat_thread_status, parent, false));
        }
        if (viewType == SELF) {
            v = LayoutInflater.from(ctx).inflate(R.layout.chat_thread_self, parent, false);
        } else {
            v = LayoutInflater.from(ctx).inflate(R.layout.chat_thread_other, parent, false);
        }
        return new MessageHolder(v);
    }

