import java.util.LinkedList;

public class Hunter {

	private String url, find;
	private LinkedList<String> links;
	private LinkedList<Page> close;

	public Hunter(String url, String find) {
		this.url = url;
		this.find = find;
		this.links = new LinkedList<String>();
		this.close = new LinkedList<Page>();
	}

	public void hunt() {
		add(url);
		Page page;
		boolean found;
		while (!close.isEmpty()) {
			page = close.pollLast();
			for (String url : page.getLinks()) {
				found = false;
				for (String link : links)
					if (link.equals(url))
						found = true;
				if (!found)
					add(url);
			}
		}
	}

	public void add(String url) {
		links.add(url);
		close.add(new Page(url, find));
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}
}
