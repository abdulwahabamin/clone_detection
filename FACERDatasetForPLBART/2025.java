    @Override
    public void onBindViewHolder(final HorizontalAdapter.MyViewHolder holder, final int position) {
      holder.txtView.setText(horizontalList.get(position));
      holder.txtView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (position < horizontalList.size() - 1) {
            path = getQiuckPath(position);
            refreshList();
          }
        }
      });
    }

