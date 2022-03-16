    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        TextCardView cardView = new TextCardView(parent.getContext());

        cardView.setBackgroundColor(parent.getResources().getColor(R.color.standard_background));
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);

        return new ViewHolder(cardView);
    }

