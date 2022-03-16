    public static void showDeleteDialog(final Context context, final String name, final long[] list, final BaseQueueAdapter qAdapter, final int pos) {

        new MaterialDialog.Builder(context)
                .title("Delete song?")
                .content("Are you sure you want to delete " + name + " ?")
                .positiveText("Delete")
                .negativeText("Cancel")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        TimberUtils.deleteTracks(context, list);
                        qAdapter.removeSongAt(pos);
                        qAdapter.notifyItemRemoved(pos);
                        qAdapter.notifyItemRangeChanged(pos, qAdapter.getItemCount());
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

