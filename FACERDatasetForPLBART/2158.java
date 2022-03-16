    public void addTabs(ViewPager viewPager) {
        List<File> files = new ArrayList<>();
        files.add(DEFAULT_PATH);
        files.add(new File(DEFAULT_PATH, "Android"));

        PagerFileListAdapter adapter = new PagerFileListAdapter(getSupportFragmentManager(), getApplicationContext());
        adapter.setFiles(files);
        viewPager.setAdapter(adapter);
    }

