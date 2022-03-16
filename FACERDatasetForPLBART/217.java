    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof RightHolder) {
            ((RightHolder) viewHolder).tvText.setText(list.get(i).getText());
        } else {
            ((LeftHolder) viewHolder).tvText.setText(list.get(i).getText());
        }
    }

