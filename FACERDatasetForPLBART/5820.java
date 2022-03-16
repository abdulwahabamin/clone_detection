        @Override
        protected void onPostExecute(Integer result) {
            try {
                zos.flush();
                zos.close();
            } catch (IOException e) {
                Log.e(TAG, "error while closing zos", e);
            }
            progressDialog.cancel();
            if (result == error){
                Toast.makeText(activity, R.string.compressing_error, Toast.LENGTH_SHORT).show();
            } else if (result == success){
                Toast.makeText(activity, R.string.compressing_success, Toast.LENGTH_SHORT).show();
            }

            if (activity.getIntent().getAction().equals(FileManagerIntents.ACTION_MULTI_SELECT)){
                Intent intent = activity.getIntent();
                activity.setResult(activity.RESULT_OK, intent);
                activity.finish();
            } else {
                activity.refreshList();
            }
        }

