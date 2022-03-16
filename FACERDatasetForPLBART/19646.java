		@Override
		public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
			
			//Only respond to user presses.
			if (checkBox.isPressed()) {
				String filePath = (String) checkBox.getTag();
                if (isChecked)
				    mFragment.getMusicFoldersHashMap().put(filePath, true);
                else
                    if (mFragment.getMusicFoldersHashMap().containsKey(filePath))
                        removeKeyAndSubFolders(filePath);
                    else
                        mFragment.getMusicFoldersHashMap().put(filePath, false);
				
			}
			
		}

