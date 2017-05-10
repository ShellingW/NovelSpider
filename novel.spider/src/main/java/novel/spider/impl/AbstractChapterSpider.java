package novel.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.spider.entitys.Chapter;
import novel.spider.enums.NovelSiteEnum;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderUtil;

public abstract class AbstractChapterSpider implements IChapterSpider {
	
	protected String crawl(String url) throws Exception{
		try(CloseableHttpClient httpClient=HttpClientBuilder.create().build();
			CloseableHttpResponse httpResponse = httpClient.execute(new HttpGet(url))){	
			String result =EntityUtils.toString(httpResponse.getEntity(),NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("chartset"));			//可以动态在此获取网页编码格式
			return result;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public List<Chapter> getsChapter(String url) {
		try{
			
			String result = crawl(url);
			Document doc = Jsoup.parse(result);
			doc.setBaseUri(url);
			Elements as = doc.select(NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl(url)).get("chapter-list-selector"));
			List<Chapter> chapters = new ArrayList<>();
			for (Element a : as) {
				Chapter chapter = new Chapter();
				chapter.setTitle(a.text());
				chapter.setUrl(a.absUrl("href"));                     //取章节路径，可以自动区分绝对路径和相对路径
				chapters.add(chapter);
			}
			return chapters;
		}catch(Exception e){
			throw new RuntimeException(e);
		}

	}

}
