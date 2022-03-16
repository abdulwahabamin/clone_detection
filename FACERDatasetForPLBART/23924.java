    @Override
    protected void onPostExecute(Object[] params) {
        File file = (File)params[0];
        boolean shouldShare = (Boolean)params[1];

        if (shouldShare) {
            String fileName = file.getName();
            share(file, fileName.substring(0, fileName.length()-4));
        } else {
            Toast.makeText(context, context.getResources().getString(R.string.playlist_exported, file.getAbsolutePath()), Toast.LENGTH_LONG).show();
        }
    }

