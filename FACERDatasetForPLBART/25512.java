		private DirectoryPickerOnClickListener(SettingsActivity activity,
				File root) {
			this.path = root;
			files = Utils.getPotentialSubDirectories(root);
			this.activity = activity;
		}

