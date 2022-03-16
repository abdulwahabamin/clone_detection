    @Override
    protected void onPostExecute(TaskOutput output) {
        if (loading == 1) {
            progressDialog.dismiss();
        }
        decLoadingCounter();

        updateMainUI();

        handleTaskOutput(output);
    }

