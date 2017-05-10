package novel.spider.entitys;

import java.io.Serializable;



/**   
*    
* 项目名称：novel.spider   
* 类名称：Chapter   
* 类描述：小说的章节实体   
* 创建人：Shelling   
* 创建时间：2017年5月9日 上午10:14:44   
* @version        
*/

public class Chapter implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String title;
	private String url;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", url=" + url + "]";
	}


}
