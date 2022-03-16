    @Override
    public void onBindViewHolder(QuickAccessViewHolder holder, int position) {
        holder.label.setText(quickAccessList.get(position));


        switch (quickAccessList.get(position)){
            case Home.DOCUMENTS:
                holder.icon.setImageResource(R.drawable.file);
                break;

            case Home.VIDEO:
                holder.icon.setImageResource(R.drawable.video);
                break;

            case Home.IMAGES:
                holder.icon.setImageResource(R.drawable.picture);
                break;

            case Home.AUDIO:
                holder.icon.setImageResource(R.drawable.music);
        }

        holder.constraintLayout.setOnClickListener(view -> {
            if(onRecyclerItemClickListener!=null){
                onRecyclerItemClickListener.onClick(holder.constraintLayout,position);
            }
        });

        holder.constraintLayout.setOnLongClickListener(view -> {

            if(onRecyclerItemClickListener!=null)
                onRecyclerItemClickListener.onLongClick(holder.constraintLayout,position);
            return true;
        });

    }

