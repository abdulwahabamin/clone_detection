		@Override
		public void handleMessage(Message msg) {
			LanylActivity lanyl = ref.get();
			if (lanyl != null) {
				switch (msg.what) {
				case MESSAGE_STATE_CHANGE:
					switch (msg.arg1) {
					case LanylService.STATE_CONNECTED:
						lanyl.setStatus(lanyl.getString(R.string.title_connected_to, lanyl.connectedDeviceName));
						//
						lanyl.conversationArrayAdapter.clear();
						//å†?åŠ ä¸ªå½“å‰?æ—¶é—´
						lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, DateTimeFormater.getInstance().getFormatedNowTime()));
						//å…ˆæ??ç¤ºä¸€ä¸‹ç”¨æˆ·ä¿¡æ?¯ä¸?ä¿?å­˜
						lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, lanyl.getString(R.string.hint_notsaverecord)));
						lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, lanyl.getString(R.string.hint_leavemeiyoule)));
						lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, lanyl.getString(R.string.hint_copytoclip)));
						//
						break;
					case LanylService.STATE_CONNECTING:
						lanyl.setStatus(R.string.title_connecting);
						break;
					case LanylService.STATE_LISTEN:
					case LanylService.STATE_NONE:
						lanyl.setStatus(R.string.status_ready_toconnect);
						break;
					}
					break;
				case MESSAGE_WRITE:
					byte[] writeBuf = (byte[]) msg.obj;
					String writeMessage = new String(writeBuf);
					lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_SENDER, writeMessage));
					break;
				case MESSAGE_READ:
					byte[] readBuf = (byte[]) msg.obj;
					String readMessage = new String(readBuf, 0, msg.arg1);
					lanyl.conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_RECEIVER, readMessage));
					break;
				case MESSAGE_DEVICE_NAME:
					lanyl.connectedDeviceName = msg.getData().getString(DEVICE_NAME);
					Toast.makeText(lanyl.getApplicationContext(), lanyl.getString(R.string.title_connected) + lanyl.connectedDeviceName, Toast.LENGTH_SHORT).show();
					break;
				case MESSAGE_TOAST:
					Toast.makeText(lanyl.getApplicationContext(), msg.getData().getString(TOAST), Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}

