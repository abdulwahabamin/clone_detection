    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                DateFormat.SHORT, Locale.getDefault());
        final File currentFile = fileModels.get(position).getFile();

        setSizeDirectory(currentFile, position, holder);
        holder.dateView.setText(df.format(currentFile.lastModified()));
        holder.nameView.setText(currentFile.getName());
        addImageView(currentFile, holder);
    }

