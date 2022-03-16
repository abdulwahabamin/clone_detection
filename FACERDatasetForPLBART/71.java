	private void sendMessage(String message) {
		//
		boolean fortest = false;
		if (fortest) {
			conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_SENDER, message));
			conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_RECEIVER, message));
			outStringBuffer.setLength(0);
			outEditText.setText(outStringBuffer);
		}
		//

		if (chatService.getState() != LanylService.STATE_CONNECTED) {
			Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT).show();
			return;
		}

		if (message.length() > 0) {
			byte[] send = message.getBytes();
			chatService.write(send);

			outStringBuffer.setLength(0);
			outEditText.setText(outStringBuffer);
		}
	}

