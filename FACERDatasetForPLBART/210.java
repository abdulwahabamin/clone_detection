    private void initView() {
        if (device.getName() == null) {
            tvName.setText("外星人");
        } else {
            tvName.setText(device.getName());
        }

        tvAddress.setText(device.getAddress());

        list = new ArrayList<>();

        chatAdapter = new ChatAdapter(this, list);

        rvChat.setLayoutManager(new LinearLayoutManager(this));

        rvChat.setAdapter(chatAdapter);

    }

