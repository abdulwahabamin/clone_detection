	@Override
	public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
		if (d.isItemsMoving()) {
			menu.clear();
			menu.add(Menu.NONE, R.id.context_cancel_paste, Menu.FIRST, "Cancel")
					.setIcon(R.drawable.ic_action_cancel);
			menu.add(Menu.NONE, Menu.NONE, Menu.FIRST + 1,
					"Moving " + d.getNumMoving() + " items");
			menu.add(Menu.NONE, R.id.context_accept_paste, Menu.FIRST + 2,
					"PASTE").setIcon(R.drawable.ic_action_paste);
			return true;
		} else {
			menu.removeItem(R.id.context_accept_paste);
			menu.removeItem(R.id.context_cancel_paste);
			return true;
		}
	}

