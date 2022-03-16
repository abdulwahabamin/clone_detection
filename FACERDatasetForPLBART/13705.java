    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FileModel fileModel = fileModelList.get(position);
        if (fileModel.getName() != null) {
            if (fileModel.isFolder()) {
                holder.iconImageView.setImageResource(R.drawable.folder);

                holder.fileSizeTextView.setText("");
            } else {
                holder.iconImageView.setImageResource(R.drawable.file);

                holder.fileSizeTextView.setText("(" + fileModel.getFileSize() + ")");
            }

            holder.folderNameTextView.setText(fileModel.getName());
        }
    }

