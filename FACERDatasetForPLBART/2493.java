	/**
	 * Delete was confirmed by clicking confirm on the dialog fragment
	 */
	public void onDialogPositiveClick(DialogFragment dialog) {
		d.setSelectedPaths(d.getmAdapter().getCurrentPaths());
		for (int i = 0; i < d.getSelectedPaths().size(); i++) {
			//File f = new File(d.getSelectedPaths().get(i));
			//ASyncCopyFiles.DeleteRecursive(f);
			d.getmAdapter().remove(d.getSelectedPaths().get(i));
			d.getmAdapter().notifyDataSetChanged();
		}
		d.getSelectedPaths().clear();
		Toast.makeText(d.getBaseContext(), "Delete successful",
				Toast.LENGTH_SHORT).show();
		d.getMode().finish(); // Action picked, so close the CAB
	}

