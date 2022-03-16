    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StatusHolder) {
            ((StatusHolder) holder).text.setText((String) list.get(position));
        }else
        {
            message= (Message) list.get(position);
            ((MessageHolder)holder).text.setText(message.message);
            ((MessageHolder) holder).date.setText(Utils.getDateFromTimestamp(message.timestamp,"dd/MM HH:mm"));
        }

    }

