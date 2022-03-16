	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: ");
		sb.append(title);
		sb.append('\n');
		sb.append("Date: ");
		sb.append(date);
		sb.append('\n');
		sb.append("Link: ");
		sb.append(link);
		sb.append('\n');
		sb.append("Content: ");
		sb.append(content);
		sb.append('\n');
		sb.append("Category: ");
		sb.append(category);
		sb.append('\n');
		sb.append("Description: ");
		sb.append(description);
		sb.append('\n');
		return sb.toString();
	}

