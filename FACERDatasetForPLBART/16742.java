    private void setOnItemClickListener(MyViewHolder viewHolder, final MediaItemWrapper mediaItemWrapper) {
        viewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(mediaItemWrapper);
            }
        });
    }

