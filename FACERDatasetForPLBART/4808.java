	@Override
	public void onResume() {

		Fab.hide();
		super.onResume();

		//String filename="_READ_ME.txt";

		//FileManagerDisk fm = (FileManagerDisk) State.getCachedFileManager(FileManagerDisk.class);

		File file = new File(State.getStateObjectString(State.SECTION_TEXT_FILE_VIEW, StateObject.STRING_FILE_PATH));

		FileReadTask read = new FileReadTask(file.getParent(),file.getName());
		read.ReadFromSd();

		State.setCurrentSection(State.SECTION_TEXT_FILE_VIEW);
		amb = new ActionModeBack(activity, file.getName()
				,R.menu.text_edit
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {
				onOptionsItemSelected(item);
			}
		});
		//if(android.os.Build.VERSION.SDK_INT>= 19) {

			ActionBarManager.setActionBarBackV19(activity, amb);
			//setActionBarBackV19();
		//} else {
			//ActionBarManager.setActionBarBackOnly(activity, file.getName(), R.menu.basic,amb);
		//}

		webView=(WebView) view.findViewById(R.id.text_viewer_webview);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
                BriefActivityManager.openAndroidBrowserUrl(activity,url);
                return true;
            }
        });
        refresh();


		String SOURCE_FILES=Files.HOME_PATH_FILES+"/textviewer/";
        String SOURCE_TMP_FILES=Files.HOME_PATH_FILES+"/textviewertmp/";
		File test = new File(SOURCE_FILES+"default.css");
		if(!test.exists()) {
			AssetManager assetManager = getResources().getAssets();
			//InputStream inputStream = null;

			try {
				UnZip.extract(assetManager.open("highlight.zip"),SOURCE_FILES,null);
			} catch (IOException e) {
				BLog.e(e.getMessage());
			}
		}

        boolean canformat = file.length()<100000?true:false;


		StringBuilder html = new StringBuilder();
		html.append("<html><head>");
		html.append("<link rel=\"stylesheet\" href=\"../textviewer/styles/default.css\">");
		html.append("<script src=\"../textviewer/highlight.pack.js\"></script>");

        html.append("<style type=\"text/css\">html body{font-size:10px}</style>");
		html.append("</head><body><pre><code>");
		html.append(FileReadTask.getFileContent(file.getAbsolutePath()));
		html.append("</code><pre>");
        if(canformat)
            html.append("<script>setTimeout(function(){hljs.initHighlighting();},100);</script>");
        html.append("</body></html>");

        if(canformat) {
            useFile = SOURCE_TMP_FILES + Cal.getUnixTime() + ".html";
            Files.ensurePath(SOURCE_TMP_FILES);
            FileWriteTask.writeToFile(useFile, html.toString());

            //BLog.e(html.toString());
            //webView.loadData(html.toString(), "text/html", "UTF-8");
            webView.loadUrl("file://" + useFile);
        } else {
            webView.loadDataWithBaseURL("file://" + SOURCE_FILES, html.toString(), "text/html", "UTF-8",null);
        }


	}

