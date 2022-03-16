    @Override
    public void onBindViewHolder(final ItemViewHolder fileItemViewHolder, int position) {
        File file = mFileList.get(position);
        fileItemViewHolder.mTextView.setText(file.getName());

        if (file.isDirectory()) {
            fileItemViewHolder.mImageView.setImageResource(R.drawable.ic_folder_black_48dp);
        } else {
            fileItemViewHolder.mImageView.setImageResource(R.drawable.ic_description_black_48dp);
        }

        fileItemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setContextMenuPosition(fileItemViewHolder.getAdapterPosition());
                return false;
            }
        });
    }

