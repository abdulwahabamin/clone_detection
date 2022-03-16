    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType==SELF_CHAT) {
            return new RightHolder(LayoutInflater.from(context).inflate(R.layout.adapter_chat_right, viewGroup, false));
        } else {
            return new LeftHolder(LayoutInflater.from(context).inflate(R.layout.adapter_chat_left, viewGroup, false));
        }
    }

