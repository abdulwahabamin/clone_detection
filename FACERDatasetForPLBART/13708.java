        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onAdapterItemClick(view, getAdapterPosition());
                    }
                }
            });

            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, final View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    contextMenu.setHeaderTitle("Select Action");
                    contextMenu.add("Rename")
                            .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    // If activity is subscribed to adapter Click,
                                    // notify activity about it
                                    if (itemClickListener != null) {
                                        itemClickListener.onAdapterItemRenameClicked(view, getAdapterPosition());
                                    }
                                    return true;
                                }
                            });
                    contextMenu.add("Delete")
                            .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    // If activity is subscribed to adapter Click,
                                    // notify activity about it
                                    if (itemClickListener != null) {
                                        itemClickListener.onAdapterItemDeleteClicked(view, getAdapterPosition());
                                    }
                                    return true;
                                }
                            });
                }
            });
        }

