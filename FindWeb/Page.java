import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;

public class Page {

	private String url, find, content;
	private ArrayList<String> found, links;

	public Page(String url, String find) {

		this.setUrl(url);
		this.setFind(find);
		this.setFound(new ArrayList<String>());
		this.setLinks(new ArrayList<String>());

		try {
			if (Jsoup.connect(url).get().hasText()) {

				try {
					this.setContent(Jsoup.connect(url).get().html());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

				find(0);

				findUrl(0);

				if (found.size() > 0) {
					System.out.println(this.toString());
				}

				content = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public boolean equals(String url) {
		return url.equals(this.url);

	}

	private void findUrl(int fromIndex) {

		int indexOf = content.indexOf(url, fromIndex);
		if (indexOf != -1) {
			int index = indexOf;
			while (!content.substring(index, index + 1).equals("\"")) {
				index++;
			}
			String link = content.substring(indexOf, index);

			if (!link.contains(".js") && !link.contains(".css") && !link.contains(".woff") && !link.contains(".ttf")
					&& !link.contains(".svg") && !link.contains("/feed"))
				links.add(link);
			findUrl(index);
		}
	}

	private void find(int fromIndex) {

		int indexOf = content.indexOf(find, fromIndex);
		if (indexOf != -1) {
			int index = indexOf;
			while (!content.substring(index, index + 1).equals("\"")) {
				index++;
			}
			found.add(content.substring(indexOf, index));
			find(index);
		}
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		String string = "Page [ \n url=" + url + ", \n found= \n ";
		for (String url : found) {
			string += "\t" + url + ",\n";
		}
		string += "]";
		return string;
	}

	/**
	 * @return the find
	 */
	public String getFind() {
		return find;
	}

	/**
	 * @param find
	 *            the find to set
	 */
	public void setFind(String find) {
		this.find = find;
	}

	/**
	 * @return the links
	 */
	public ArrayList<String> getLinks() {
		return links;
	}

	/**
	 * @param links
	 *            the links to set
	 */
	private void setLinks(ArrayList<String> links) {
		this.links = links;
	}

	public ArrayList<String> getFound() {
		return found;
	}

	public void setFound(ArrayList<String> found) {
		this.found = found;
	}

}
