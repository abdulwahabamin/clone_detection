		@Override
		public void onClick(View v) {
			PopupMenu menu = new PopupMenu(mContext, v);
			menu.inflate(R.menu.artist_overflow_menu);
			//menu.setOnMenuItemClickListener(popupMenuItemClickListener);
			mName = (String) v.getTag(R.string.artist);
		    menu.show();
			
		}

