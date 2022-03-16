    @Override
    public void onClick(View v) {

        if(!isConnected)
        {
            Utils.showToast(this,"Not Connected to "+name_other);
            return;
        }
        if (Utils.getText(message).isEmpty())
        {
            return;
        }
        connection.write(Utils.getText(message));
        message.setText("");
    }

