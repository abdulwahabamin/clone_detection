        public boolean accept(File dir, String name) {
            try {
                File file = new File(name);
                name = name.toLowerCase(Locale.getDefault());
                if (file.isDirectory()) {
                    return true;
                } else if (name.endsWith(".3gp")) {
                    return true;
                } else if (name.endsWith(".flac")) {
                    return true;
                } else if (name.endsWith(".mp3")) {
                    return true;
                } else if (name.endsWith(".mid")) {
                    return true;
                } else if (name.endsWith(".ogg")) {
                    return true;
                } else if (name.endsWith(".wav")) {
                    return true;
                }
            } catch (Exception e) {
                Log.d("",e.getLocalizedMessage());
            }
            return false;
        }

