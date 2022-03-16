    @Override
    public Parcelable saveState() {
        Bundle state = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        for (File file : fileList) {
            arrayList.add(file.getAbsolutePath());
        }
        state.putStringArrayList(KEY_FRAGMENT, arrayList);
        return state;

    }

