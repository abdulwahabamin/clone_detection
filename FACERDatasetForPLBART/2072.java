    private void setSizeDirectory(File file, int position, ViewHolder holder) {
        Long longSizeFile = fileModels.get(position).getSizeDirectory();
        String strSizeFile = FileUtils.formatCalculatedSize(longSizeFile);
        if (longSizeFile != 0) {
            holder.sizeItemView.setText(strSizeFile);
        }

        if (!cacheSizeDirectory.isEmpty()) {
            String path = file.getAbsolutePath();
            if (cacheSizeDirectory.containsKey(path)) {
                longSizeFile = cacheSizeDirectory.get(path);
                strSizeFile = FileUtils.formatCalculatedSize(longSizeFile);
                holder.sizeItemView.setText(strSizeFile);
            } else {
                addFileSizeText(file, holder);
            }
        } else {
            addFileSizeText(file, holder);
        }
    }

