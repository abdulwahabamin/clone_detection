		public int getLayoutId() {
			switch (renderType) {
			case TYPE_SENDER:
				return com.viyu.lanyl.R.layout.listitem_message_right;
			case TYPE_RECEIVER:
				return com.viyu.lanyl.R.layout.listitem_message_left;
			case TYPE_HINT:
				return com.viyu.lanyl.R.layout.listitem_message_hint;
			case TYPE_ADS:
			}
			return -1;
		}

