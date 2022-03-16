    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message=mMessageList.get(position);
        holder.icon.setImageResource(message.getIconId());
        Log.d(TAG, "onBindViewHolder: "+message.getAppName());
        holder.appName.setText(message.getAppName());
        holder.fileName.setText(message.getFileName());
        holder.time.setText(message.getTime());
    }

