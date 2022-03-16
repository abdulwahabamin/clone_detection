    @Override
    public boolean onLongClick(View v) {
        if (adapter.getDataList().size() <= 1) {
            return false;
        }
        new AlertDialog.Builder(context)
                .setTitle(data.name)
                .setMessage(R.string.whether_delete)
                .setPositiveButton(R.string.delete, (dialog, which) -> deleteCity())
                .setNegativeButton(R.string.cancel, null)
                .show();
        return true;
    }

