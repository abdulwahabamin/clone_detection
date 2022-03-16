    @Override
    public void onBindViewHolder(StorageViewHolder holder, int position) {
        holder.label.setText(storageList.get(position).getTitle());
        holder.progressBar.setProgress(storageList.get(position).getPercentage());
        holder.percentage.setText(storageList.get(position).getPercentage()+"%");
        holder.free.setText(storageList.get(position).getFree());
        holder.total.setText(storageList.get(position).getTotal());
        holder.used.setText(storageList.get(position).getUsed());
        holder.rootView.setOnClickListener(view -> {
            if(onRecyclerItemClickListener!=null)
                onRecyclerItemClickListener.onClick(view,position);
        });
    }

