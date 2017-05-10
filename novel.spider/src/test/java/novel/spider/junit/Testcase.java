package novel.spider.junit;

import java.util.List;

import org.junit.Test;

import novel.spider.entitys.Chapter;
import novel.spider.enums.NovelSiteEnum;
import novel.spider.impl.DefaultChapterSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderUtil;

public class Testcase {
	@Test
	public void testGetChapter() throws Exception {
		IChapterSpider spider = new DefaultChapterSpider();
		List<Chapter>  chapters  = spider.getsChapter("http://www.motie.com/book/75604/chapter");
		for (Chapter chapter : chapters) {
			System.out.println(chapter);
		}
	}
	
	@Test
	public void testGetSiteContext(){
		System.out.println(NovelSpiderUtil.getContext(NovelSiteEnum.getEnumByUrl("http://www.bxwx9.org/b/62/62724/index.html")));
	}
	
	
}
