        public final String getDefMasks( int i ) {
            switch( i ) {
            case 1: return "/*;*/";     // directories
            case 2: return "*.gif;*.jpg;*.png;*.bmp";
            case 3: return "*.avi;*.mov;*.mp4;*.mpeg";
            case 4: return "*.mp3;*.wav;*.mid*";
            case 5: return "*.htm*;*.xml;*.pdf;*.csv;*.doc*;*.xls*";
            case 6: return "*.apk;*.zip;*.jar;*.rar";
            }
            return null;
        }

