    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, int position) {
        FilePOJO list_items = list_members.get(position);
        holder.user_name.setText(list_items.getFileName());
        holder.content.setText(list_items.getDetail());
        holder.image.setImageResource(getImageId(list_items.getFileImage()));
        Log.i("Steps","onBindViewHolder");
    }

