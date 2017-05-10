package novel.spider.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import novel.spider.enums.NovelSiteEnum;


public final class NovelSpiderUtil {
	public static final Map<NovelSiteEnum,Map<String,String>>CONTEXT_MAP=new HashMap<>();	
	static{
		init();
		
	}
	
	private NovelSpiderUtil(){}
	
	private static void init(){
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("conf/Spider-Rule.xml"));
			Element root = doc.getRootElement();
			List<Element>sites = root.elements("site");
			for(Element site :sites){
				List<Element>subs =site.elements();
				Map<String,String>subMap= new HashMap<>();
				for(Element sub : subs){
					String name =sub.getName();
					String text= sub.getTextTrim();
					subMap.put(name, text);
				}
				CONTEXT_MAP.put(NovelSiteEnum.getEnumByUrl(subMap.get("url")), subMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**   
	*    
	* 项目名称：novel.spider   
	* 类名称：NovelSpiderUtil   
	* 类描述：   拿到对应网站的解析规则
	* 创建人：Shelling   
	* 创建时间：2017年5月10日 上午11:06:38   
	* @version        
	*/
	
	public static Map<String,String> getContext(NovelSiteEnum novelSiteEnum){
			return CONTEXT_MAP.get(novelSiteEnum);
	
	}
}