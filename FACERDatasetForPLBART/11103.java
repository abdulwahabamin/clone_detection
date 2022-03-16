    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
          case android.R.id.home:
              setResult(RESULT_OK);
              finish();
              return true;
          default:
             return super.onOptionsItemSelected(item);
       }
    }

