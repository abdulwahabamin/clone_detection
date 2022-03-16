    public void sendMessage(View arg)
    {
        String s=et.getText().toString();
        bcs.rwt.writeMessage(s);
        al.add("Me: " +s);
        arr.notifyDataSetChanged();
        et.setText("");
    }

