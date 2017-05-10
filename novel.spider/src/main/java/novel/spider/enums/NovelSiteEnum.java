package novel.spider.enums;

/**
 * 
 * 项目名称：novel.spider 类名称：NovelSiteEnum 类描述：已经支持的小说网站枚举 创建人：Shelling
 * 创建时间：2017年5月10日 上午10:35:11
 * 
 * @version
 */
public enum NovelSiteEnum {
	DINGDIANXIAOSHUO(1, "23us.com"), BIQUGE(2, "biqudu.com"), BIXIAWENXUE(3,
			"bxwx9.org"), MOTIEWENXUE(4, "motie.com");
	private int id;
	private String url;

	private NovelSiteEnum(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static NovelSiteEnum getEnumById(int id){
		switch(id){
		case 1:return DINGDIANXIAOSHUO;
		case 2:return BIQUGE;
		case 3:return BIXIAWENXUE;
		case 4:return MOTIEWENXUE;
		default : throw new RuntimeException("id="+id+"是不被支持的网站！");
		}
	}
	public static NovelSiteEnum getEnumByUrl(String url){
		//www.23us.com/ssasw
		for(NovelSiteEnum novelSiteEnum : values()){
			if(url.contains(novelSiteEnum.url)){
				return novelSiteEnum;
			}
		}
		 throw new RuntimeException("url="+url+"是不被支持的网站！");
	}
}
