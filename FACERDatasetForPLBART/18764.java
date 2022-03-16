	public final JSONForm addFields(Map<String, String> fields) throws IOException {
		for(String key : fields.keySet()) {
			addField(key, fields.get(key));
		}

		return this;
	}

