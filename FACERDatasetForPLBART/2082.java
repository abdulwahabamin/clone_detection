    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        if (state != null) {
            Bundle bundle = (Bundle) state;
            bundle.setClassLoader(loader);
            ArrayList<String> arrayList = ((Bundle) state).getStringArrayList(KEY_FRAGMENT);

            List<File> files = new ArrayList<>();
            assert arrayList != null;
            for (String path : arrayList) {
                files.add(new File(path));
            }
            setFiles(files);
        }
    }

