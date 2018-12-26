import com.baizhi.dao.*;
import com.baizhi.entity.*;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.dc.pr.PRError;

import javax.swing.*;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MyTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private GuruDao guruDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CarouselDao carouselDao;
    @Test
    public void insert(){
        Menu menu=new Menu();
        menu.setMenu_id(UUID.randomUUID().toString());
        menu.setTitle("用户管理");
        menu.setIconCls("home");
        menu.setHref("caidan");
        menu.setParent_id("2");
        menuDao.insert(menu);
    }
    @Test
    public void showAll(){
        List<Menu> list = menuDao.queryAll();
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }
    @Test
    public void queryUser(){
        User kxf = userDao.queryUser("kxf", "1234");
        System.out.println(kxf);
    }
    @Test
    public void showAllCarousel(){
        List<Carousel> list=carouselDao.queryAll();
        System.out.println(list);
    }
    @Test
    public void insertCarousel(){
        Carousel carousel=new Carousel();
        carousel.setCarousel_id(UUID.randomUUID().toString());
        carousel.setTitle("经院佛堂");
        carousel.setCdesc("经院佛堂");
        carousel.setImgPath("/carouselimg/2.jpg");
        carousel.setStatus("y");
        carousel.setCrateTime(new Date());

        carouselDao.insert(carousel);
    }
    @Test
    public void aaa(){
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void updateCarousel(){
        Carousel carousel=new Carousel("40972eca-f886-4e5a-872b-81a0b7172181","经院佛堂","经院佛堂","/carouselimg/2.jpg","n",new Date());

        carouselDao.update(carousel);
    }
    @Test
    public void deleteCarousel(){
        carouselDao.delete("40972eca-f886-4e5a-872b-81a0b7172181");
    }

    @Test
    public void insertGuru(){
        Guru guru=new Guru();
        guru.setGuru_id(UUID.randomUUID().toString());
        guru.setName("赵霖");
        guru.setProfile("6.jpg");
        guru.setSex("男");
        guruDao.insert(guru);
    }
    @Test
    public void findAllGuru(){
        List<Guru> gurus = guruDao.queryAll();
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }
    @Test
    public void updateGuru(){
        Guru guru=new Guru("ac743d56-9449-48eb-949f-8583a5593013","赵霖","6.jpg","女");
        guruDao.update(guru);
    }
    @Test
    public void deleteGuru(){
        guruDao.delete("ac743d56-9449-48eb-949f-8583a5593013");
    }
    @Test
    public void insertAlbum(){
        Album album=new Album();
        album.setId(UUID.randomUUID().toString());
        album.setTitle("米拉日巴尊者传");
        album.setCover("/7.jpg");
        album.setAuthor("第十五世香根活佛");
        album.setCounts(10);
        album.setBroadcast("王猛师兄");
        album.setScore(5);
        album.setPublisDate(new Date());
        album.setBrief("真好");
        albumDao.insert(album);
    }
    @Autowired
    private ChapterDao chapterDao;
    @Test
    public void insertChapter(){
        Chapter chapter=new Chapter("a85b24be-6b48-4380-a970-5dbe7b146129","泠鸢yousa,银临 - 怀梦之泽.mp3","6M","248",null,"E:\\ideacode\\cmfz_Kxf\\target\\cmfz_Kxf-1.0-SNAPSHOT\\uploadChapter","0618fc56-1a03-4c64-a10c-7004ed2c8833");

        chapterDao.insert(chapter);
    }
    @Test
    public void showAllAlbum(){
        List<Album> albums = albumDao.queryAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    @Test
    public void deleteAlbum(){
        albumDao.delete("ec7b7fe0-148a-4108-854b-496a18b40128");
    }
//    @Test
//    public void updateAlbum(){
//        Album album=new Album("c29f5a11-914a-449c-9232-19bed6f4e355","甘露明珠","/6.jpg","第十五世香根活佛",10,"王猛师兄",5,new Date(),"真好");
//        albumDao.update(album);
//    }
    @Test
    public void queryUserName(){
        Admin admin=adminService.queryAdmin("kong");
        System.out.println(admin);
    }


    @Test
    public void querys(){
        List<Map<String, Integer>> query = userDao.query();
        for (Map<String, Integer> integerMap : query) {
            System.out.println(integerMap);
        }
    }
    @Test
    public void test111(){

    }


}
