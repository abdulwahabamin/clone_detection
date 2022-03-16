    private void addImageView(File file, ViewHolder holder) {
        if (file.isFile()) {
            holder.imageView.setImageResource(R.drawable.file);
        } else {
            holder.imageView.setImageResource(R.drawable.path);
        }
    }

