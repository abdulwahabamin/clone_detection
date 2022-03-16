    public List<String> showAllStorages()
    {
        String[] folders_array;
        File folders = new File(Environment.getExternalStorageDirectory().getPath().substring(0, Environment.getExternalStorageDirectory().getPath().lastIndexOf("/")));
        String internal_memory = Environment.getExternalStorageDirectory().getPath().substring(Environment.getExternalStorageDirectory().getPath().lastIndexOf("/") + 1, Environment.getExternalStorageDirectory().getPath().length());
        folders_array = folders.list();
        List<String> result = new ArrayList<>();
        for(String item : folders_array)
        {
            if (item.equals(internal_memory))
            {
                item = item + " (sdcard0)";
            }
            else
            {
                item = item + " (sdcard1)";
            }
            result.add(item);
        }
        result.remove(result.size() - 1);
        String temp = result.get(0);
        result.set(0, result.get(1));
        result.set(1, temp);
        return result;
    }

