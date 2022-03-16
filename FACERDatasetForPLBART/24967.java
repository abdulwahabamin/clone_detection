    private void toggleSelection(int position) {
        playlistGridAdapter.toggleSelection(position);
        int count = playlistGridAdapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
    }

