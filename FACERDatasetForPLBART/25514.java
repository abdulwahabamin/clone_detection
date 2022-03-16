		private void showDirectoryPicker() {
			final Item[] items = new Item[files.size() + 2];
			for(int i = 0;i<files.size();i++){
				items[i + 2] = new Item(files.get(i).getName(), R.drawable.ic_action_collection);
			}
			
			items[0] = new Item(path.getAbsolutePath(), R.drawable.ic_pgmp_launcher);
			//items[0] = new Item(activity.getResources().getString(R.string.directorydialoghere), R.drawable.ic_pgmp_launcher);
			items[1] = new Item(activity.getResources().getString(R.string.directorydialogup), android.R.drawable.ic_menu_upload);
			
			ListAdapter adapter = new ArrayAdapter<Item>(
				    activity,
				    android.R.layout.select_dialog_item,
				    android.R.id.text1, items){
				        public View getView(int position, View convertView, ViewGroup parent) {
				            //User super class to create the View
				            View v = super.getView(position, convertView, parent);
				            TextView tv = (TextView)v.findViewById(android.R.id.text1);

				            //Put the image on the TextView
				            tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);

				            //Add margin between image and text (support various screen densities)
				            int dp5 = (int) (5 * activity.getResources().getDisplayMetrics().density + 0.5f);
				            tv.setCompoundDrawablePadding(dp5);

				            return v;
				        }
				    };
			new AlertDialog.Builder(activity).setTitle(activity.getResources().getString(R.string.directorydialogprompt))
					.setIcon(android.R.drawable.ic_menu_zoom)
					.setAdapter(adapter, this).show();
		}

