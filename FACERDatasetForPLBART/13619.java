    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AppModel appModel = appModelList.get(position);
        if (appModel.getAppIcon() != null) {
            holder.iconImageView.setImageDrawable(appModel.getAppIcon());
        } else {
            holder.iconImageView.setImageResource(R.mipmap.ic_launcher);
        }
        String appText = appModel.getAppName();
        if (appText == null) {
            appText = appModel.getPackageName();
        }
        holder.folderNameTextView.setText(appText);

        holder.fileSizeTextView.setText("");
    }

