package cn.com.pingtech.senseFace.pojo;

/**
 * @Auther: psf
 * @Date: 2019/9/2 13:23
 * @Description:
 */
public class Image {
    private Image1 image;
    private String face_selection;

    public Image1 getImage() {
        return image;
    }

    public void setImage(Image1 image) {
        this.image = image;
    }

    public String getFace_selection() {
        return face_selection;
    }

    public void setFace_selection(String face_selection) {
        this.face_selection = face_selection;
    }

    public Image(Image1 image, String face_selection) {
        this.image = image;
        this.face_selection = face_selection;
    }

    public Image() {
    }
}
