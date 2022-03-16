    @SuppressLint("HandlerLeak")
    private void initData() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ChatService.WRITE_DATA_SUCCESS:
                        Log.i(TAG, "write success");
                        String selfText = (String) msg.obj;
                        Chat selfChat = new Chat(selfText, true);
                        list.add(selfChat);
                        chatAdapter.notifyItemChanged(list.size() - 1);
                        rvChat.scrollToPosition(list.size()-1);

                        break;
                    case ChatService.WRITE_DATA_FAIL:
                        Log.i(TAG, "write fail");


                        exitChatDialog("å¯¹æ–¹å·²ç»?é€€å‡ºè?Šå¤©ï¼Œå?³å°†å?œæ­¢è?Šå¤©", false);


                    case ChatService.READ_DATA_FAIL:

                        exitChatDialog("å¯¹æ–¹å·²ç»?é€€å‡ºè?Šå¤©ï¼Œå?³å°†å?œæ­¢è?Šå¤©", false);

                        break;

                    case ChatService.READ_DATA_SUCCESS:
                        Log.i(TAG, "read success");
                        String text = (String) msg.obj;
                        Chat chat = new Chat(text, false);
                        list.add(chat);
                        chatAdapter.notifyItemChanged(list.size() - 1);
                        rvChat.scrollToPosition(list.size()-1);
                        break;

                }
            }
        };

        if (isClient) {
            clientService = ClientService.getInstance(handler);

            clientService.connect(device, uuid);
        } else {
            serverService = ServerService.getInstance(handler);
        }

    }

