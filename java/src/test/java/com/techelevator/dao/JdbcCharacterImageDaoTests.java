package com.techelevator.dao;

import com.techelevator.model.CharacterImage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcCharacterImageDaoTests extends BaseDaoTests {

    private JdbcCharacterImageDao jdbcCharacterImageDao;


    @Before
    public void setup(){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcCharacterImageDao = new JdbcCharacterImageDao(jdbcTemplate);
    }

    @Test
    public void addImage_creates_new_image() {
        //arrange
        String url = "https://bootcamp-os-lms-prd-public.s3.us-west-2.amazonaws.com/content/tech-elevator-nav.png";

        //act
        CharacterImage newImage = jdbcCharacterImageDao.addImage(url);

        //assert
        Assert.assertEquals(5,newImage.getId());
        Assert.assertTrue(url.equals(newImage.getUrl()));
        Assert.assertEquals(false,newImage.isApproved());
    }

    @Test
    public void getImageById_returns_null_if_not_found() {
        //arrange

        //act
        CharacterImage newImage = jdbcCharacterImageDao.getImageById(5);

        //assert
        Assert.assertNull(newImage);

    }

    @Test
    public void getImageById_returns_correct_image() {
        //arrange
        CharacterImage image1 = new CharacterImage();
        image1.setId(1);
        image1.setUrl("fakeurl1");
        image1.setApproved(true);
        CharacterImage image3 = new CharacterImage();
        image3.setId(3);
        image3.setUrl("fakeurl3");
        image3.setApproved(false);

        //act
        CharacterImage newImage1 = jdbcCharacterImageDao.getImageById(1);
        CharacterImage newImage3 = jdbcCharacterImageDao.getImageById(3);

        //assert
        assertImagesMatch(image1,newImage1);
        assertImagesMatch(image3,newImage3);

    }

    @Test
    public void getUnapprovedImages_returns_correct_number_of_images() {
        //arrange

        //act
        List<CharacterImage> unapprovedImages = jdbcCharacterImageDao.getUnapprovedImages();

        //assert
        Assert.assertEquals(2,unapprovedImages.size());

    }

    @Test
    public void getUnapprovedImages_returns_only_unapproved_images() {
        //arrange
        CharacterImage image3 = new CharacterImage();
        image3.setId(3);
        image3.setUrl("fakeurl3");
        image3.setApproved(false);

        CharacterImage image4 = new CharacterImage();
        image4.setId(4);
        image4.setUrl("fakeurl4");
        image3.setApproved(false);

        //act
        List<CharacterImage> unapprovedImages = jdbcCharacterImageDao.getUnapprovedImages();

        //assert
        assertImagesMatch(image3,unapprovedImages.get(0));
        assertImagesMatch(image4,unapprovedImages.get(1));

    }

    @Test
    public void approveImages_changes_state_of_images_to_approved() {
        //arrange
        CharacterImage image1 = new CharacterImage();
        image1.setId(1);
        image1.setUrl("fakeurl1");
        image1.setApproved(true);
        CharacterImage image3 = new CharacterImage();
        image3.setId(3);
        image3.setUrl("fakeurl3");
        image3.setApproved(false);

        //act
        jdbcCharacterImageDao.approveImage(1);
        jdbcCharacterImageDao.approveImage(3);


        CharacterImage newImage1 = jdbcCharacterImageDao.getImageById(1);
        CharacterImage newImage3 = jdbcCharacterImageDao.getImageById(3);

        //assert
        Assert.assertTrue(newImage1.isApproved());
        Assert.assertTrue(newImage3.isApproved());

    }

    private void assertImagesMatch(CharacterImage expected, CharacterImage actual) {
        Assert.assertEquals(expected.getId(),actual.getId());
        Assert.assertTrue(expected.getUrl().equals(actual.getUrl()));
        Assert.assertEquals(expected.isApproved(),actual.isApproved());
    }

}
