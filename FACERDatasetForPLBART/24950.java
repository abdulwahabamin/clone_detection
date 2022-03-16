    private void toggleSelection(int position) {
        songListAdapter.toggleSelection(position);
        int count = songListAdapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
    }

