        @Override
        protected void onPostExecute(Integer result) {
            progressDialog.cancel();
            if (result == error){
                Toast.makeText(activity, R.string.extracting_error, Toast.LENGTH_SHORT).show();
            } else if (result == success){
                Toast.makeText(activity, R.string.extracting_success, Toast.LENGTH_SHORT).show();
            }
            activity.refreshList();
        }

