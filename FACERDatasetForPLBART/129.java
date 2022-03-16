		public int getMessageViewId() {
			switch (renderType) {
			case TYPE_SENDER:
				return com.viyu.lanyl.R.id.listitem_message_right_text;
			case TYPE_RECEIVER:
				return com.viyu.lanyl.R.id.listitem_message_left_text;
			case TYPE_HINT:
				return com.viyu.lanyl.R.id.listitem_message_hint_text;
			case TYPE_ADS:
			}
			return -1;
		}

