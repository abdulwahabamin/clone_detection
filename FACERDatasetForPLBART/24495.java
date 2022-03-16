    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ActionCardView cardView = new ActionCardView(parent.getContext());

        cardView.setBackgroundColor(parent.getResources().getColor(R.color.standard_background));
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);

        return new ViewHolder(cardView);
    }

