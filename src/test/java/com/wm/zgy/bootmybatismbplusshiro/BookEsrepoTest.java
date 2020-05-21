package com.wm.zgy.bootmybatismbplusshiro;

import com.wm.zgy.bootmybatismbplusshiro.pojo.Book;
import com.wm.zgy.bootmybatismbplusshiro.service.ElasticSearchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author renjiaxin
 * @Date 2020/5/20
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookEsrepoTest {

    @Autowired
    ElasticSearchService esService;

    @Test
    public void testCreateIndex() throws IOException {
        Assert.assertEquals(true, esService.createIndex("ppp"));

    }

    @Test
    public void testGetIndex() throws IOException {
        Assert.assertEquals(true, esService.getIndex("hello"));

    }

    @Test
    public void testDeleteIndex() throws IOException {
        Assert.assertEquals(true, esService.deleteIndex("ppp"));

    }


    @Test
    public void testInsertBook() throws IOException {
        String overView = "中国古典四大名著之一，是最优秀的神话小说，也是一部群众创作和文人创作相结合的作品。" +
                "小说以整整七回的“大闹天宫”故事开始，把孙悟空的形象提到全书首要的地位。第八至十二回写如来说法，" +
                "观音访僧，魏徵斩龙，唐僧出世等故事，交待取经的缘起。从十四回到全书结束，写孙悟空被迫皈依佛教，保护唐僧取经，" +
                "在八戒、沙僧协助下，一路斩妖除魔，到西天成了“正果”";
        LocalDate date = LocalDate.of(1552, 2, 5);
        String extras = " xiyouji -test";
        Book book = Book.builder().id(1).name("西游记").author("吴承恩").price(27).press("长江文艺出版社").
                overview(overView).issueDate(date).type("古典神魔").extras(extras).build();
        System.out.println(book.toString());
        esService.addBookDocument(book, "books", "4", 1);

    }

    @Test
    public void testExistsBookDocument() throws IOException {
        System.out.println(esService.existsBookDocument("books", "1"));

    }

    @Test
    public void testGetBookDocument() throws IOException {
        System.out.println(esService.getBookDocument("books", "4"));

    }

    @Test
    public void testDeleteBookDocument() throws IOException {
        System.out.println(esService.deleteBookDocument("books", "2"));

    }

    // 会把其他的部分冲掉，覆盖其他部分，是一个全量的更新，而非增量更新
    @Test
    public void testUpdateBookDocument() throws IOException {
        // Book book = Book.builder().id(100).author("河东智叟许仲林").name("封神演义").overview("封神演义讲述了武王伐纣的故事").build();
        Book book = Book.builder().issueDate(LocalDate.of(1522,12,9)).build();
        System.out.println(esService.updateBookDocument(book, "books", "3", 1));

    }

    @Test
    public void testUpdateBookDocumentByMap() throws IOException {
        Map<String, Object> mp = new HashMap<>();
//        mp.put("name","封神榜");
//        mp.put("author","河东智叟许仲林");
//        mp.put("overview","武王伐纣啊");
        mp.put("type","==");
        System.out.println(esService.updateBookDocumentByMap(mp, "books", "3", 1));
    }

    @Test
    public void testBul() throws IOException {
        ArrayList as = new ArrayList();
        as.add(Book.builder().name("红楼梦").author("曹雪芹").overview("贾宝玉和林黛玉的爱情故事").type("古典爱情").build());
        as.add(Book.builder().name("三国演义").author("罗贯中").overview("东汉末年天下三分").type("历史战争").build());
        as.add(Book.builder().name("水浒传").author("施耐庵").overview("北宋末年宋江起义").type("战争").build());
        as.add(Book.builder().name("呐喊").author("鲁迅").overview("对封建礼教的控诉").type("白话").build());
        as.add(Book.builder().name("家春秋").author("巴金").overview("对封建礼教的控诉").type("白话 家庭").build());
        as.add(Book.builder().name("百年孤独").author("马尔克斯").overview("魔幻现实主义").type("拉美 魔幻现实").build());
        as.add(Book.builder().name("动物庄园").author("奥威尔").overview("乌托邦讽刺小说").type("反乌托邦").build());

        System.out.println(esService.batchAddBookDocument(as, "books", 200));

    }
}
