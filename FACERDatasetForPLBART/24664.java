	private List<MP3Info> parse(String xmlStr) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		List<MP3Info> infos = null;
		try {
			XMLReader reader = factory.newSAXParser().getXMLReader();

			infos = new ArrayList<MP3Info>();
			MP3ListContentHandler handler = new MP3ListContentHandler(infos);
			reader.setContentHandler(handler);
			reader.parse(new InputSource(new StringReader(xmlStr)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return infos;
	}

