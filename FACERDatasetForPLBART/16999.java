    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View contactView = LayoutInflater.from(mContext).inflate(viewType, parent, false);
        return typeFactory.createViewHolder(contactView, viewType);
    }

