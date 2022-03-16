    @Override
    public void onBindViewHolder(MyViewVolder holder, int position) {
        User user=list.get(position);
        holder.name.setText(user.name);
        holder.last_message.setText(user.last_message);
        if (user.last_msg_time>user.last_read_time)
        {
            holder.name.setTypeface(null, Typeface.BOLD);
            holder.last_message.setTypeface(null, Typeface.BOLD_ITALIC);
        }else {
            holder.name.setTypeface(null, Typeface.NORMAL);
            holder.last_message.setTypeface(null, Typeface.NORMAL);
        }
    }

