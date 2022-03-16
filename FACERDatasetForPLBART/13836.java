    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.filter_az) {
            dataAdapter.sort(new MusicAlphabeticComparator());
        } else if (id == R.id.filter_date) {
            dataAdapter.sort(new MusicDateComparator());
        } else if (id == R.id.filter_size) {
            dataAdapter.sort(new MusicSizeComparator());
        }
        return super.onOptionsItemSelected(item);
    }

