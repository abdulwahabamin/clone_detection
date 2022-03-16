    public M3UHolder parseFile(File f) throws FileNotFoundException {
        if (f.exists()) {
            String stream = convertStreamToString(new FileInputStream(f));
            stream = stream.replaceAll("#EXTM3U", "").trim();
            String[] arr = stream.split("#EXTINF.*,");
            String urls = "", data = "";
            	
            for (int n = 0; n < arr.length; n++) {
                if (arr[n].contains("http")) {
                        String nu = arr[n].substring(arr[n].indexOf("http://"),
                                        arr[n].indexOf(".mp3") + 4);

                        urls = urls.concat(nu);
                        data = data.concat(arr[n].replaceAll(nu, "").trim())
                                        .concat("&&&&");
                        urls = urls.concat("####");
                }
                
            }
            return new M3UHolder(data.split("&&&&"), urls.split("####"));
        }
        return null;
    }

