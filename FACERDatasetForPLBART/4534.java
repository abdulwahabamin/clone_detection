		@Override
		public void onClick(View view) {
            File to = new File(usefile.getParentFile().getAbsolutePath() + File.separator + renameText.getText().toString()+Files.getExtension(usefile.getName()));
            BLog.e("renameing to: " + to.getAbsolutePath());
            usefile.renameTo(to);
            shouldRefresh=true;
			thisDialog.dismiss();
		}

