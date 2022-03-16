    private void sendMessage(String message) {
        if (mChatService.getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();
            return;
        }

        if (message.length() > 0) {
            byte[] send = message.getBytes();
            mChatService.write(send);
            etMessage.setText("");
        }else{
            Toast.makeText(this, "Empty Message!", Toast.LENGTH_SHORT).show();
        }
    }

