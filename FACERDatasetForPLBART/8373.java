    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
          case android.R.id.home:
              // release Console lock held by the async search task
              if (mExecutable != null) {
                  mExecutable.end();
              }
              back(true, null, false);
              return true;
          default:
             return super.onOptionsItemSelected(item);
       }
    }

