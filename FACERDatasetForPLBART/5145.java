	public static String htmlWrap(String message) {
		StringBuilder head=new StringBuilder();
		StringBuilder foot=new StringBuilder();
		if(message.indexOf("<html")==-1) {
			head.append("<html>");
			foot.append("</html>");
		}
		if(message.indexOf("<body")==-1) {
			head.append("<body style=\"margin:0px,padding:0px\">");
			foot.append("</body>");
		} else {
			message.replace("</body>", "<style type=\"text/css\">html body{margin:0px,padding:0px}</style></body>");
		}
		return head+message+foot;
	}

