    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.contentTextView.setText(messageList.get(position).getContent());
        holder.horaireTv.setText(messageList.get(position).getHoraire());

        if(messageList.get(position).getIdenvoye()== ME){
            holder.messageParent.setGravity(Gravity.START);
        }else{
            holder.messageParent.setGravity(Gravity.END);
        }
    }

