    private static int getCategory(int iconfile, String filename) {
        int category = 0;
        switch(iconfile) {
            case R.drawable.f_jpg: category=Files.CAT_IMAGE; break;
            case R.drawable.f_gif: category=Files.CAT_IMAGE; break;
            case R.drawable.f_png: category=Files.CAT_IMAGE; break;
            case R.drawable.f_svg: category=Files.CAT_IMAGE; break;
            case R.drawable.f_bmp: category=Files.CAT_IMAGE; break;
            case R.drawable.f_psd: category=Files.CAT_IMAGE; break;
            case R.drawable.f_tiff: category=Files.CAT_IMAGE; break;
            case R.drawable.f_ai: category=Files.CAT_IMAGE; break;
            case R.drawable.f_eps: category=Files.CAT_IMAGE; break;
            case R.drawable.f_ps: category=Files.CAT_IMAGE; break;

            case R.drawable.f_mp3: category=Files.CAT_SOUND; break;
            case R.drawable.f_wav: category=Files.CAT_SOUND; break;
            case R.drawable.f_wma: category=Files.CAT_SOUND; break;

            case R.drawable.f_m4v: category=Files.CAT_VIDEO; break;
            case R.drawable.f_3gp: category=Files.CAT_VIDEO; break;
            case R.drawable.f_avi: category=Files.CAT_VIDEO; break;
            case R.drawable.f_mp4: category=Files.CAT_VIDEO; break;
            case R.drawable.f_mov: category=Files.CAT_VIDEO; break;
            case R.drawable.f_mpg: category=Files.CAT_VIDEO; break;
            case R.drawable.f_wmv: category=Files.CAT_VIDEO; break;

            case R.drawable.f_doc: category=Files.CAT_DOCUMENT; break;
            case R.drawable.f_docx: category=Files.CAT_DOCUMENT; break;
            case R.drawable.f_odt: category=Files.CAT_DOCUMENT; break;
            case R.drawable.f_pdf: category=Files.CAT_DOCUMENT; break;

            case R.drawable.f_xls: category=Files.CAT_SPREADSHEET; break;
            case R.drawable.f_ods: category=Files.CAT_SPREADSHEET; break;

            case R.drawable.f_ppt: category=Files.CAT_POWERPOINT; break;
            case R.drawable.f_odp: category=Files.CAT_POWERPOINT; break;

            case R.drawable.f_zip: category=Files.CAT_COMPRESSION; break;
            case R.drawable.f_7z: category=Files.CAT_COMPRESSION; break;
            case R.drawable.f_rar: category=Files.CAT_COMPRESSION; break;
            case R.drawable.f_gzip: category=Files.CAT_COMPRESSION; break;

            case R.drawable.f_txt: category=Files.CAT_TEXTFILE; break;
            case R.drawable.f_htm: category=Files.CAT_TEXTFILE; break;
            case R.drawable.f_js: category=Files.CAT_TEXTFILE; break;
            case R.drawable.f_jsp: category=Files.CAT_TEXTFILE; break;
            case R.drawable.f_css: category=Files.CAT_TEXTFILE; break;
            case R.drawable.f_sql: category=Files.CAT_TEXTFILE; break;


            default: category=Files.CAT_UNKNOWN;
        }
        if(category==0) {
            if(Files.isTextFile(filename))
                category=Files.CAT_TEXTFILE;
        }
        return category;
    }

