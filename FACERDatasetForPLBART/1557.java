    @Override
    public void onBindViewHolder(@NonNull MessageListViewHolder messageListViewHolder, int i) {
        // i'll have to change background and stuff for sender and receiver
   String message = messageList.get(i).getMessage();
   messageListViewHolder.text_tv.setText(message);
    }

