    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate out card list item

        View view;
        switch (viewType) {
            case AboutModel.ABOUT_1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.about_card_layout_1, parent, false);
                return new About1ViewHolder(view);
            case AboutModel.ABOUT_2:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.about_card_layout_2, parent, false);
                return new About2ViewHolder(view);
            case AboutModel.ABOUT_3:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.about_card_layout_3, parent, false);
                return new About3ViewHolder(view);
            case AboutModel.ABOUT_4:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.about_card_layout_4, parent, false);
                return new About4ViewHolder(view);
            case AboutModel.ABOUT_5:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.about_card_layout_5, parent, false);
                return new About5ViewHolder(view);
            default:
                return null;
        }
    }

