    @Override
    public void onBindViewHolder(StorageChooserViewHolder holder, int position) {
        holder.constraintLayout.setOnClickListener(view -> {
            if(onRecyclerItemClickListener!=null)
                onRecyclerItemClickListener.onClick(view,position);
        });
        holder.title.setText(storageSelectionList.get(position).getTitle());
        holder.path.setText("("+storageSelectionList.get(position).getPath()+")");
        if(storageSelectionList.get(position).getTitle().charAt(0)=='I'){
            holder.icon.setImageResource(R.drawable.smartphone);
        }else
            holder.icon.setImageResource(R.drawable.sd_card);
    }

