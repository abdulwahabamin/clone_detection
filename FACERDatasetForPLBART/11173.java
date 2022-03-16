    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (mResultList != null && !mResultList.isEmpty()) {
            new SearchResultFilterTask().execute(MimeTypeHelper.MimeTypeCategory.values()[i]);
        }
    }

