    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object o) {
        CategoryItem item = (CategoryItem) o;
        TextCardView cardView = (TextCardView) viewHolder.view;

        cardView.setTitleText(item.name);
        cardView.setContentText(
                viewHolder.view.getContext().getResources().getQuantityString(R.plurals.Nsongs, item.count, item.count));
    }

