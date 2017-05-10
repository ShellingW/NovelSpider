package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Chapter;

/**   
*    
* 项目名称：novel.spider   
* 类名称：IChapterSpider   
* 类描述：   给一个完整的url，返回所有章节
* 创建人：Shelling   
* 创建时间：2017年5月9日 上午10:54:34   
* @version        
*/
public interface IChapterSpider {
	
	public List<Chapter>getsChapter(String url);
}
