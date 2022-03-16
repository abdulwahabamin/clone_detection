    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat,menu);
        btn_connect=menu.findItem(R.id.action_connect);
        if (isConnected)
        {
            btn_connect.setTitle(getString(R.string.menu_disconnect));
        }
        return super.onCreateOptionsMenu(menu);
    }

